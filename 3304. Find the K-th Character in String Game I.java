class Solution {
    //TC:O(1 + 2 + 4 + 8 + … + k) = O(k), SC: O(k)
    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder("a");

        while (sb.length() < k) {
            int size = sb.length();
            for (int i = 0; i < size; i++) {
                sb.append((char) ('a' + ((sb.charAt(i) - 'a') + 1) % 26));
            }
        }

        return sb.charAt(k - 1);
    }
}