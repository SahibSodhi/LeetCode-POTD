class Solution {
    // Approach 2 - Tabulation
    // TC: O(N), SC: O(N)
    public int numTilings(int n) {
        if (n < 3)
            return n;

        int MOD = 1_000_000_007;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (int) ((2L * dp[i - 1] + dp[i - 3]) % MOD);
        }

        return dp[n];
    }

    // // Approach 1 - Recursion + Memoization
    // // TC: O(N) -> bcos |r1 - r2| <= 1, SC: O(N^2)
    // Integer[][] dp = new Integer[1005][1005];
    // int MOD = 1_000_000_007;

    // int countTilingWays(int r1, int r2) {
    // if (r1 == 0 && r2 == 0)
    // return 1;
    // if (r1 < 0 || r2 < 0)
    // return 0;
    // if (dp[r1][r2] != null)
    // return dp[r1][r2];

    // long count = 0;
    // if (r1 == r2) {
    // count += countTilingWays(r1 - 2, r2 - 2); // Horizontal tile both
    // count += countTilingWays(r1 - 1, r2 - 1); // Vertical tile
    // count += countTilingWays(r1 - 2, r2 - 1); // Inverted L
    // count += countTilingWays(r1 - 1, r2 - 2); // Mirror L
    // } else if (r1 > r2) {
    // count += countTilingWays(r1 - 2, r2); // Horizontal tile row-1
    // count += countTilingWays(r1 - 2, r2 - 1); // Inverted L Mirror
    // } else {
    // count += countTilingWays(r1, r2 - 2); // Horizontal tile row-2
    // count += countTilingWays(r1 - 1, r2 - 2); // L shape
    // }

    // return dp[r1][r2] = (int) (count % MOD);
    // }

    // public int numTilings(int n) {
    // return countTilingWays(n, n);
    // }

    // //Approach 2 - DP
    // //TC: O(n), SC: O(n)
    // public int numTilings(int n) {
    // int MOD = 1_000_000_007;
    // if (n <= 1) return 1;
    // if (n == 2) return 2;
    // if (n == 3) return 5;

    // long[] dp = new long[n + 1];
    // dp[0] = 1; dp[1] = 1; dp[2] = 2; dp[3] = 5;

    // for (int i = 4; i <= n; i++) {
    // dp[i] = (2 * dp[i - 1] % MOD + dp[i - 3]) % MOD;
    // }

    // return (int) dp[n];
    // }
}