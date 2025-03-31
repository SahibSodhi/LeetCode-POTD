import java.util.Arrays;

class Solution {
    // Approach 1 - Sorting; 2nd Approach can to be recursively check for all the possible contiguous subarrays
    // Time Complexity: O(nlogn)
    // Space Complexity: O(n)
    public long putMarbles(int[] weights, int k) {
        if (k == 1) {
            return 0;
        }

        int n = weights.length;
        long[] splits = new long[n - 1];

        for (int i = 0; i < n - 1; i++) {
            splits[i] = weights[i] + weights[i + 1];
        }

        Arrays.sort(splits);

        long maxScore = 0, minScore = 0;
        
        // Add the smallest k - 1 splits
        for (int i = 0; i < k - 1; i++) {
            minScore += splits[i];
        }

        // Add the largest k - 1 splits
        for (int i = n - 2; i >= n - k; i--) {
            maxScore += splits[i];
        }

        return maxScore - minScore;
    }
}
