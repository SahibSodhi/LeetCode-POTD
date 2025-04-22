class Solution {
    static final int MOD = 1_000_000_007;
    int maxN = 10000;
    long[][] comb = new long[10001][15]; // Because length max is 10^4 and log2(10^4) ~ 14

    public int idealArrays(int n, int maxValue) {
        // Precompute combinations: C(n, k)
        for (int i = 0; i <= n; i++) {
            comb[i][0] = 1;
            for (int j = 1; j < 15 && j <= i; j++) {
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }

        // dp[x] = number of divisor chains ending with x of length <= 14
        int maxLen = 14; // Enough since n <= 10^4 and log2(10^4) ~ 14
        int[][] dp = new int[maxValue + 1][maxLen + 1];
        for (int i = 1; i <= maxValue; i++) {
            dp[i][1] = 1; // base case
        }

        for (int len = 2; len <= maxLen; len++) {
            for (int i = 1; i <= maxValue; i++) {
                for (int j = 2 * i; j <= maxValue; j += i) {
                    dp[j][len] = (dp[j][len] + dp[i][len - 1]) % MOD;
                }
            }
        }

        long res = 0;
        for (int i = 1; i <= maxValue; i++) {
            for (int len = 1; len <= maxLen; len++) {
                long ways = dp[i][len];
                long combinations = comb[n - 1][len - 1]; // choose (len - 1) positions to place increases
                res = (res + ways * combinations % MOD) % MOD;
            }
        }
        return (int) res;
    }
}
