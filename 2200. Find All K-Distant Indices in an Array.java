class Solution {
    //Approach 1 - Enumeration
    //TC: O(n^2), SC: O(1)
    // public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
    //     List<Integer> res = new ArrayList<>();
    //     int n = nums.length;
    //     // traverse number pairs
    //     for (int i = 0; i < n; ++i) {
    //         for (int j = 0; j < n; ++j) {
    //             if (nums[j] == key && Math.abs(i - j) <= k) {
    //                 res.add(i);
    //                 break; // early termination to prevent duplicate addition
    //             }
    //         }
    //     }
    //     return res;
    // }

    //Approach 2 - One-time traversal
    //TC: O(n), SC: O(1)
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        int r = 0; // unjudged minimum index
        int n = nums.length;
        for (int j = 0; j < n; ++j) {
            if (nums[j] == key) {
                int l = Math.max(r, j - k);
                r = Math.min(n - 1, j + k) + 1;
                for (int i = l; i < r; ++i) {
                    res.add(i);
                }
            }
        }
        return res;
    }
}