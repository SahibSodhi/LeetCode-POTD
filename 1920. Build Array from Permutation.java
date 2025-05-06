class Solution {
    //Approach 2 - Build In Place
    //TC: O(n), SC: O(1)
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        // Build the final value on the first iteration
        for (int i = 0; i < n; ++i) {
            nums[i] += 1000 * (nums[nums[i]] % 1000);
        }
        // Modified to final value on the second iteration
        for (int i = 0; i < n; ++i) {
            nums[i] /= 1000;
        }
        return nums;
    }

    // //Approach 1 - Build As Required
    // //TC: O(n), SC: O(1)
    // public int[] buildArray(int[] nums) {
    //     int n = nums.length;
    //     int[] ans = new int[n];
    //     for (int i = 0; i < n; ++i) {
    //         ans[i] = nums[nums[i]];
    //     }
    //     return ans;
    // }
}