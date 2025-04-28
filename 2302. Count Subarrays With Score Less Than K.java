class Solution {
    //Approach 1 - Sliding Window + Running Sum
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length; 
        int left = 0;
        long total = 0;
        long count = 0;

        for(int right = 0; right < n; right++){
            total += nums[right];

            while(total * (right - left + 1) >= k){
                total -= nums[left];
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }
}