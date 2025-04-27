class Solution {
    //Approach 1 - Sliding Window
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    // public int countSubarrays(int[] nums) {
    //     int n = nums.length;
    //     int left = 0;
    //     int count = 0;

    //     for(int right = 0; right < n; right++){
    //         while(right - left != 2){
    //             right++;
    //         }
    //         if(nums[left + 1] == 2 * (nums[left] + nums[right])){
    //             count++;
    //         }
    //         left++;
    //     }

    //     return count;

    // }

    //Approach 2 - One Pass
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public int countSubarrays(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 1; i < n - 1; ++i) {
            if (nums[i] == (nums[i - 1] + nums[i + 1]) * 2) {
                ++ans;
            }
        }
        return ans;
    }
}