class Solution {
    //Approach 1 - Traversal
    //TC: O(n), SC: O(1) 
    public int differenceOfSums(int n, int m) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m == 0) {
                ans -= i;
            } else {
                ans += i;
            }
        }
        return ans;
    }

    //Approach 2 - Mathematical Derivation
    //TC: O(1), SC: O(1)
    public int differenceOfSums(int n, int m) {
        int k = n / m;
        return (n * (n + 1)) / 2 - k * (k + 1) * m;
    }
}