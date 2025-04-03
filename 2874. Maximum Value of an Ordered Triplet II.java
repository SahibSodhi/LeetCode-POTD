public class Solution {
    // Approach 2 - Greedy
    // TC: O(n), SC: O(1)
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long res = 0, imax = 0, dmax = 0;
        for (int k = 0; k < n; k++) {
            res = Math.max(res, dmax * nums[k]);
            dmax = Math.max(dmax, imax - nums[k]);
            imax = Math.max(imax, nums[k]);
        }
        return res;
    }

    // //Approach 1 - Greedy + Prefix Sum Array
    // //TC: O(n), SC: O(n)
    // public long maximumTripletValue(int[] nums) {
    // int n = nums.length;
    // int[] leftMax = new int[n];
    // int[] rightMax = new int[n];

    // for (int i = 1; i < n; i++) {
    // leftMax[i] = Math.max(leftMax[i - 1], nums[i - 1]);
    // rightMax[n - 1 - i] = Math.max(rightMax[n - i], nums[n - i]);
    // }
    // long res = 0;
    // for (int j = 1; j < n - 1; j++) {
    // res = Math.max(res, (long) (leftMax[j] - nums[j]) * rightMax[j]);
    // }
    // return res;
    // }
}