class Solution {
    //Time complexity - O(n log n + len(words) * 16) → O(n log n)
    //Space complexity - O(n)
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Map<String, Integer> dp = new HashMap<>();
        int maxLen = 0;

        for (String word : words) {
            int longest = 1; // At least the word itself
            for (int i = 0; i < word.length(); i++) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                longest = Math.max(longest, dp.getOrDefault(prev, 0) + 1);
            }
            dp.put(word, longest);
            maxLen = Math.max(maxLen, longest);
        }

        return maxLen;
    }
}
