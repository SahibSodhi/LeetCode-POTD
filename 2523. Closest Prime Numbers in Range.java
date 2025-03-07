import java.util.Arrays;

class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] prime = new boolean[right + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        int prev = -1;
        int minDiff = Integer.MAX_VALUE;
        int[] result = new int[] { -1, -1 };

        // Checking only up to √n in the outer loop reduces unnecessary iterations.
        // Starting the inner loop from p * p prevents redundant operations.
        for (int p = 2; p * p <= right; p++) {
            if (prime[p]) {
                for (int j = p * p; j <= right; j += p) {
                    prime[j] = false;
                }
            }
        }

        for (int i = left; i <= right; i++) {
            if (prime[i]) {
                if (prev == -1) {
                    prev = i;
                } else {
                    if (i - prev < minDiff) {
                        minDiff = i - prev;
                        result[0] = prev;
                        result[1] = i;
                    }
                    prev = i;
                }
            }
        }

        return result;
    }
}