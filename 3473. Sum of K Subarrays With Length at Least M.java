import java.util.Arrays;

class Solution {
    public int maxSum(int[] nums, int k, int m) {
        int n = nums.length;
        int[][] dp = new int[n+1][k+1];
        int[] prefix = new int[n+1];

        for(int[] row: dp){
            Arrays.fill(row, -100000000); // -10^8 -> Large enough negative number; Generally we use -1 for intialising dp array
            //We can't use -1 here as -10^4 <= nums[i] <= 10^4
        }

        for(int i = 0; i <= n; i++){
            dp[i][0] = 0;
        }

        // We have used prefix sum to calculate the sum of subarrays
        for(int i = 1; i <= n; i++){
            prefix[i] = prefix[i-1] + nums[i-1];
        }

        for(int j = 1; j <= k; j++){
            int bestOffset = -100000000; // -10^8 -> Large enough negative number
            for(int i = 1; i <= n; i++){
                dp[i][j] = dp[i-1][j];
                if(i - m >= 0){
                    bestOffset = Math.max(bestOffset, dp[i - m][j - 1] - prefix[i - m]);
                }
                dp[i][j] = Math.max(dp[i][j], prefix[i] + bestOffset);
            }
        }

        return dp[n][k];
    }
}