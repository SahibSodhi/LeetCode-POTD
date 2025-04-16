class Solution {
    // Approach - Binary Search
    // Time Complexity - O(log n)
    // Space Complexity - O(1)
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[mid + 1]) {
                // We are in the descending part => potential peak on the left
                end = mid;
            } else {
                // We are in the ascending part => peak must be on the right
                start = mid + 1;
            }
        }

        return start;
    }
}
