class Solution {
    //Approach 2 - Recursion
    //TC : O(2^n), SC : O(n + 2^n)
    public String countAndSay(int n) {
        if (n == 1) return "1";
        
        String prev = countAndSay(n - 1);
        StringBuilder res = new StringBuilder();
        
        int i = 0;
        while (i < prev.length()) {
            int count = 1;
            while (i + 1 < prev.length() && prev.charAt(i) == prev.charAt(i + 1)) {
                i++;
                count++;
            }
            res.append(count).append(prev.charAt(i));
            i++;
        }
        
        return res.toString();
    }

    // //Approach 1 - Brute Force
    // //TC : O(2^n), SC : O(2^n)
    // public String countAndSay(int n) {
    //     String res = "1";
    //     for (int i = 1; i < n; i++) {
    //         StringBuilder temp = new StringBuilder();
    //         int count = 1;
    //         for (int j = 1; j < res.length(); j++) {
    //             if (res.charAt(j) == res.charAt(j - 1)) {
    //                 count++;
    //             } else {
    //                 temp.append(count).append(res.charAt(j - 1));
    //                 count = 1;
    //             }
    //         }
    //         temp.append(count).append(res.charAt(res.length() - 1));
    //         res = temp.toString();
    //     }
    //     return res;
    // }
}