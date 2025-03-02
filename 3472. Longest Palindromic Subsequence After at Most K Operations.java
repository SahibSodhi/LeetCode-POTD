import java.util.Arrays;

class Solution {
    // 3D DP array to store the results of subproblems
    private int[][][] dp;
    
    // Function to compute the distance between two characters in a circular alphabet (26 letters)
    private int distance(char a, char b) {
        int dist = Math.abs(a - b); // Direct difference
        return Math.min(dist, 26 - dist); // Minimum distance considering circular behavior
    }

    // Recursive function to find the longest palindromic subsequence with at most k changes
    private int solveDP(String s, int i, int j, int k) {
        // Base Case: If left index crosses right index, no valid subsequence
        if (i > j) return 0;
        
        // Base Case: Single character is always a palindrome of length 1
        if (i == j) return 1;

        // Memoization: If already computed, return the stored result
        if (dp[i][j][k] != -1) return dp[i][j][k];

        // Case 1: Ignore s[i] and solve for (i+1, j)
        int op1 = solveDP(s, i + 1, j, k);

        // Case 2: Ignore s[j] and solve for (i, j-1)
        int op2 = solveDP(s, i, j - 1, k);

        // Maximum of ignoring either character
        int ans = Math.max(op1, op2);

        // Compute the transformation cost between s[i] and s[j]
        int c = distance(s.charAt(i), s.charAt(j));

        // Case 3: If characters can be matched within k operations, consider the pair
        if (c <= k) {
            ans = Math.max(ans, 2 + solveDP(s, i + 1, j - 1, k - c));
        }

        // Store and return the result
        dp[i][j][k] = ans;
        return ans;
    }

    public int longestPalindromicSubsequence(String s, int k) {
        int n = s.length();

        // Initialize DP array for memoization
        dp = new int[n][n][k + 1];

        // Fill the DP array with -1 to indicate uncomputed states
        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, -1);
            }
        }

        // Start recursion from the full string with k allowed changes
        return solveDP(s, 0, n - 1, k);
    }
}
