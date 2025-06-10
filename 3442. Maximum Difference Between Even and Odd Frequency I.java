class Solution {
    //TC: O(n), SC: O(26) = O(1)
    public int maxDifference(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;

        for (int num : freq) {
            if (num % 2 != 0) {
                maxOdd = Math.max(maxOdd, num);
            }
            if (num % 2 == 0 && num > 0) {
                minEven = Math.min(minEven, num);
            }
        }

        // Check if valid values were found
        if (maxOdd == Integer.MIN_VALUE || minEven == Integer.MAX_VALUE) {
            return -1; // or throw exception or handle appropriately
        }

        return maxOdd - minEven;
    }
}
