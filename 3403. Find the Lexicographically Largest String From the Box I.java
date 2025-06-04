class Solution {
    //Approach 2 - Two pointers
    //TC: O(n), SC: O(n)
    public String lastSubstring(String s) {
        int i = 0, j = 1, n = s.length();
        while (j < n) {
            int k = 0;
            while (j + k < n && s.charAt(i + k) == s.charAt(j + k)) {
                k++;
            }
            if (j + k < n && s.charAt(i + k) < s.charAt(j + k)) {
                int t = i;
                i = j;
                j = Math.max(j + 1, t + k + 1);
            } else {
                j = j + k + 1;
            }
        }
        return s.substring(i);
    }

    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        String last = lastSubstring(word);
        int n = word.length(), m = last.length();
        return last.substring(0, Math.min(m, n - numFriends + 1));
    }

    // //Approach 1 - Enumeration
    // //TC: O(n^2), SC: O(n)
    // public String answerString(String word, int numFriends) {
    //     if (numFriends == 1) {
    //         return word;
    //     }

    //     int n = word.length();
    //     String res = "";

    //     for (int i = 0; i < n; i++) {
    //         String s = word.substring(i, Math.min(i + n - numFriends + 1, n));
    //         if (res.compareTo(s) <= 0) {
    //             res = s;
    //         }
    //     }
    //     return res;
    // }
}