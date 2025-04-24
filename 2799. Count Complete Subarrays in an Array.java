class Solution {
    // //Approach 1 - Brute Force (Using Two Pointers)
    // // Time Complexity: O(n^2)
    // // Space Complexity: O(n)
    // public int countCompleteSubarrays(int[] nums) {
    //     int k = (int) Arrays.stream(nums).distinct().count(), res = 0;
    //     for (int i = 0; i < nums.length; i++) {
    //         Set<Integer> st = new HashSet<>();
    //         for (int j = i; j < nums.length; j++) {
    //             st.add(nums[j]);
    //             if (st.size() == k) res++;
    //         }
    //     }
    //     return res;
    // }

    //Approach 2 - Sliding Window
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int countCompleteSubarrays(int[] nums) {
        int left = 0, res = 0;
        int k = (int) Arrays.stream(nums).distinct().count();
        Map<Integer, Integer> mpp = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
            while (mpp.size() == k) {
                res += nums.length - i;
                mpp.put(nums[left], mpp.get(nums[left]) - 1);
                if (mpp.get(nums[left]) == 0) mpp.remove(nums[left]);
                left++;
            }
        }
        return res;
    }
}