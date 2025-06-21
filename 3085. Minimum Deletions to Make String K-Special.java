class Solution {
    //Approach - HashMap +Enumeration
    //TC: O(n + C^2), SC: O(C); C is the size of the character set, which is 26 in this case.

    public int minimumDeletions(String word, int k) {
        Map<Character, Integer> cnt = new HashMap<>();

        for (char ch : word.toCharArray()) {
            cnt.put(ch, cnt.getOrDefault(ch, 0) + 1);
        }

        int res = word.length();
        for (int a : cnt.values()) {
            int deleted = 0;
            for (int b : cnt.values()) {
                if (a > b) {
                    deleted += b;
                } else if (b > a + k) {
                    deleted += b - (a + k);
                }
            }

            res = Math.min(res, deleted);
        }

        return res;
    }
}