class Solution {
    // Approach 3 - Optimised Sliding window approach (Only one while loop instead of two)
    // TC: O(n), SC: O(1)
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int length = 0;
        int maxLength = 0;
        int zeroesCount = 0;
        int left = 0;
        int right = 0;

        while (right < n) {
            if (nums[right] == 0) {
                zeroesCount++;
            }

            if (zeroesCount > k) {// We are not letting maxLength to be updated until we find a zero; even if the
                                  // window is invalid we are moving left pointer
                if (nums[left] == 0)
                    zeroesCount--;
                left++;
            }

            length = right - left + 1;
            maxLength = Math.max(maxLength, length);

            right++;
        }

        return maxLength;
    }

    // Approach 2 - Sliding window approach
    // TC: O(n) + O(n) = O(n), SC: O(1)
    // public int longestOnes(int[] nums, int k) {
    // int n = nums.length;
    // int length = 0;
    // int maxLength = 0;
    // int zeroesCount = 0;
    // int left = 0;
    // int right = 0;

    // while (right < n) {
    // if (nums[right] == 0) {
    // zeroesCount++;
    // }

    // while (zeroesCount > k) {
    // if (nums[left] == 0)
    // zeroesCount--;
    // left++;
    // }

    // length = right - left + 1;
    // maxLength = Math.max(maxLength, length);

    // right++;
    // }

    // return maxLength;
    // }

    // //Approach 1 - Brute force - finding max zeroes in all subarrays
    // //TC: O(n^2), SC: O(1)
    // public int longestOnes(int[] nums, int k) {
    // int n = nums.length;
    // int maxLength = 0;

    // for(int i = 0; i < n; i++){
    // int length = 0; int zeroesCount = 0;
    // for(int j = i; j < n; j++){
    // if(nums[j] == 0){
    // zeroesCount++;
    // }

    // if(zeroesCount <= k){
    // length = j - i + 1;
    // maxLength = Math.max(maxLength, length);
    // }
    // else {
    // break;
    // }
    // }
    // }

    // return maxLength;
    // }
}