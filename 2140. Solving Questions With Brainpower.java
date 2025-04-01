class Solution {
    private int n;
    private long[] dp;
    private int[][] questions;

    public long mostPoints(int[][] questions) {
        n = questions.length;
        dp = new long[n];
        this.questions = questions;
        return dfs(0);
    }

    private long dfs(int i) {
        if (i >= n) {
            return 0;
        }

        if (dp[i] != 0) {
            return dp[i];
        }

        int points = questions[i][0], brainPower = questions[i][1];
        return dp[i] = Math.max(points + dfs(i + brainPower + 1), dfs(i + 1));
    }
}