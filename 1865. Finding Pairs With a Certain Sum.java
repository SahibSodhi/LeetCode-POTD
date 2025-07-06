class FindSumPairs {
    //TC: O(n + m + q1 + q2⋅n). The initialization takes O(n+m) time to store the two arrays and build the frequency map for nums2. Each add(index, val) operation takes O(1) time, so q1 calls take O(q1) in total. Each count(tot) operation iterates over all elements in nums1 and performs a hash map lookup for each, resulting in O(n) per call. So q2calls take O(q2⋅n) in total.
    //SC: O(n + m)

    private int[] nums1;
    private int[] nums2;
    private Map<Integer, Integer> cnt;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.cnt = new HashMap<>();

        for (int num : nums2) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int oldVal = nums2[index];
        cnt.put(oldVal, cnt.get(oldVal) - 1);
        nums2[index] += val;
        cnt.put(nums2[index], cnt.getOrDefault(nums2[index], 0) + 1);
    }

    public int count(int tot) {
        int ans = 0;
        for (int num : nums1) {
            int rest = tot - num;
            ans += cnt.getOrDefault(rest, 0);
        }

        return ans;
    }
}