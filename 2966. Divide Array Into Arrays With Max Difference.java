class Solution {
    //Approach - Sorting
    //TC: O(nlogn), SC : O(logn) //Some extra space is used when we sort an array of size N in place. In Java, Arrays.sort() is implemented using a variant of the Quick Sort algorithm which has a space complexity of O(logN).

    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);

        int[][] ans = new int[nums.length / 3][3];

        for (int i = 0; i < nums.length; i += 3) {
            if (nums[i + 2] - nums[i] > k) {
                return new int[0][0];
            }
            ans[i / 3] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
        }
        return ans;
    }
}