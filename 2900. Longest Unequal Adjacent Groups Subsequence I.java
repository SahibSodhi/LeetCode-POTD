class Solution {
    //Approach 2 - Greedy
    //TC: O(n), SC: O(1)
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            if (i == 0 || groups[i] != groups[i - 1]) {
                ans.add(words[i]);
            }
        }
        return ans;
    }

    // //Approach 1 - Dynamic Programming
    // //TC: O(n^2), SC: O(n)
    // public List<String> getLongestSubsequence(String[] words, int[] groups) {
    //     int n = words.length;
    //     int[] dp = new int[n];
    //     int[] prev = new int[n];
    //     int maxLen = 1, endIndex = 0;

    //     for (int i = 0; i < n; i++) {
    //         dp[i] = 1;
    //         prev[i] = -1;
    //     }
    //     for (int i = 1; i < n; i++) {
    //         int bestLen = 1;
    //         int bestPrev = -1;
    //         for (int j = i - 1; j >= 0; j--) {
    //             if (groups[i] != groups[j] && dp[j] + 1 > bestLen) {
    //                 bestLen = dp[j] + 1;
    //                 bestPrev = j;
    //             }
    //         }
    //         dp[i] = bestLen;
    //         prev[i] = bestPrev;
    //         if (dp[i] > maxLen) {
    //             maxLen = dp[i];
    //             endIndex = i;
    //         }
    //     }

    //     List<String> res = new ArrayList<>();
    //     for (int i = endIndex; i != -1; i = prev[i]) {
    //         res.add(words[i]);
    //     }
    //     Collections.reverse(res);
    //     return res;
    // }
}