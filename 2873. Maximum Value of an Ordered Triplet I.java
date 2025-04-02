class Solution {
    // Approach 4 - Greedy - Fix value of k
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

    // //Approach 3 - Greedy + Prefix Sum Array
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

    // //Approach 2 - Greedy - Find max value of i in [0,j) while keeping k and j
    // fixed
    // //TC: O(n^2), SC: O(1)
    // public long maximumTripletValue(int[] nums) {
    // int n = nums.length;
    // long res = 0;
    // for (int k = 2; k < n; k++) {
    // int maxPrefix = nums[0];
    // for (int j = 1; j < k; j++) {
    // res = Math.max(res, (long) (maxPrefix - nums[j]) * nums[k]);
    // maxPrefix = Math.max(maxPrefix, nums[j]);
    // }
    // }
    // return res;
    // }

    // //Approach 1 - Try all possible triplets
    // //TC: O(n^3), SC: O(1)
    // public long maximumTripletValue(int[] nums) {
    // int n = nums.length;
    // long maxValue = 0;

    // for(int i = 0; i < n; i++){
    // for(int j = i + 1; j < n; j++){
    // for(int k = j + 1; k < n; k++){
    // maxValue = Math.max(maxValue, (long)(nums[i] - nums[j]) * nums[k]);
    // }
    // }
    // }

    // return maxValue;
    // }
}