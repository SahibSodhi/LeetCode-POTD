class Solution {
    //Approach - Greedy
    //TC: O(n * |S|), SC: O(n + |S|); Let n be the length of the string s, and let 
    //|S| be the size of the character set. Since all characters in this problem are lowercase letters, we have |S| = 26
    public String clearStars(String s) {
        Deque<Integer>[] cnt = new Deque[26];
        for (int i = 0; i < 26; i++) {
            cnt[i] = new ArrayDeque<>();
        }
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '*') {
                cnt[arr[i] - 'a'].push(i);
            } else {
                for (int j = 0; j < 26; j++) {
                    if (!cnt[j].isEmpty()) {
                        arr[cnt[j].pop()] = '*';
                        break;
                    }
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for (char c : arr) {
            if (c != '*') {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}