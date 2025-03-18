class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int bitMask = 0;
        int start = 0;
        int maxLen = 0;

        for(int end = 0; end < n; end++){
            // If current number shares bits with window, shrink window from left
            // until there's no bit conflict
            while((bitMask & nums[end]) != 0){
                bitMask = bitMask ^ nums[start];
                start++;
            }

            // Add current number to the window
            bitMask = bitMask | nums[end];

            // Update max length if current window is longer
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }
}