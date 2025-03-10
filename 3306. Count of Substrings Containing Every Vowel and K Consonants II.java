class Solution {
    public long countOfSubstrings(String word, int k) {
        //2 variable size sliding window
        return atLeast(k, word) - atLeast(k + 1, word);
    }

    private boolean isAllVowelsPresent(int[] freq) {
        return (freq['a' - 'a'] > 0 && freq['e' - 'a'] > 0 && freq['i' - 'a'] > 0 && freq['o' - 'a'] > 0 && freq['u' - 'a'] > 0);
    }

    private boolean isConsonant(char ch) {
        return (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u');
    }

    private long atLeast(int k, String word) {
        int n = word.length();
        int[] freq = new int[26];
        int currConsonant = 0;
        long count = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            char ch = word.charAt(right);
            if (isConsonant(ch)) {
                currConsonant++;
            }
            freq[ch - 'a']++;

            while (currConsonant >= k && isAllVowelsPresent(freq)) {
                count += (n - right);
                char c = word.charAt(left);
                if(isConsonant(c)) {
                    currConsonant--;
                }
                freq[c - 'a']--;
                left++;
            }
        }

        return count;
    }
}