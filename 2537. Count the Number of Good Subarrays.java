import java.util.HashMap;

class Solution {
    //Approach 1 - Sliding Window + HashMap
    //Time Complexity - O(n)
    //Space Complexity - O(n)
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        int same = 0, right = -1;
        HashMap<Integer, Integer> cnt = new HashMap<>();
        long ans = 0;

        for (int left = 0; left < n; ++left) {
            while (same < k && right + 1 < n) {
                ++right;
                same += cnt.getOrDefault(nums[right], 0);
                cnt.put(nums[right], cnt.getOrDefault(nums[right], 0) + 1);
            }
            if (same >= k) {
                ans += n - right;
            }
            cnt.put(nums[left], cnt.get(nums[left]) - 1);
            same -= cnt.get(nums[left]);
        }
        
        return ans;
    }

    //Approach 2 - Sliding Window + HashMap (Count Bad Subarrays; Good = Total - Bad)
    //Time Complexity - O(n)
    //Space Complexity - O(n)

    // public long countGood(int[] nums, int k) {
    //     int n = nums.length;
    //     long ans = 0;
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     int same = 0, left = 0;

    //     for (int right = 0; right < n; right++) {
    //         same += map.getOrDefault(nums[right], 0);
    //         map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

    //         while (same >= k) {
    //             map.put(nums[left], map.get(nums[left]) - 1);
    //             same -= map.get(nums[left]);
    //             left++;
    //         }

    //         ans += (right - left + 1);
    //     }

    //     long totalSubarrays = (long) n * (n + 1) / 2;
    //     return totalSubarrays - ans;
    // }
}