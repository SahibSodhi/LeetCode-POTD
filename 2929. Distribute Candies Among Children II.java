class Solution {
    // //Approach 1 - Enumeration
    // //TC: O(min(limit,n)), SC: O(1)
    // public long distributeCandies(int n, int limit) {
    //     long ans = 0;
    //     for (int i = 0; i <= Math.min(limit, n); i++) {
    //         if (n - i > 2 * limit) {
    //             continue;
    //         }
    //         ans += Math.min(n - i, limit) - Math.max(0, n - i - limit) + 1;
    //     }
    //     return ans;
    // }

    //Approach 2 - Inclusion-Exclusion Principle
    //TC: O(1), SC: O(1)
    public long distributeCandies(int n, int limit) {
        return (
            cal(n + 2) -
            3 * cal(n - limit + 1) +
            3 * cal(n - (limit + 1) * 2 + 2) -
            cal(n - 3 * (limit + 1) + 2)
        );
    }

    public long cal(int x) {
        if (x < 0) {
            return 0;
        }
        return ((long) x * (x - 1)) / 2;
    }
}