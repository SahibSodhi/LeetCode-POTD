public class Solution {
    // //Approach 1 - DFS
    // //TC: O(n), SC: O(d) = O(logn); d = 5 as max value of n is 50,000; d = num of digits
    // public List<Integer> lexicalOrder(int n) {
    //     List<Integer> lexicographicalNumbers = new ArrayList<>();
    //     // Start generating numbers from 1 to 9
    //     for (int start = 1; start <= 9; ++start) {
    //         generateLexicalNumbers(start, n, lexicographicalNumbers);
    //     }
    //     return lexicographicalNumbers;
    // }

    // private void generateLexicalNumbers(int currentNumber, int limit, List<Integer> result) {
    //     // If the current number exceeds the limit, stop recursion
    //     if (currentNumber > limit) return;

    //     // Add the current number to the result
    //     result.add(currentNumber);

    //     // Try to append digits from 0 to 9 to the current number
    //     for (int nextDigit = 0; nextDigit <= 9; ++nextDigit) {
    //         int nextNumber = currentNumber * 10 + nextDigit;
    //         // If the next number is within the limit, continue recursion
    //         if (nextNumber <= limit) {
    //             generateLexicalNumbers(nextNumber, limit, result);
    //         } else {
    //             break; // No need to continue if nextNumber exceeds limit
    //         }
    //     }
    // }

    //Approach 2 - Iterative Approach
    //TC: O(n), SC: O(1)
    public List<Integer> lexicalOrder(int n) {
        List<Integer> lexicographicalNumbers = new ArrayList<>();
        int currentNumber = 1;

        // Generate numbers from 1 to n
        for (int i = 0; i < n; ++i) {
            lexicographicalNumbers.add(currentNumber);

            // If multiplying the current number by 10 is within the limit, do it
            if (currentNumber * 10 <= n) {
                currentNumber *= 10;
            } else {
                // Adjust the current number by moving up one digit
                while (currentNumber % 10 == 9 || currentNumber >= n) {
                    currentNumber /= 10; // Remove the last digit
                }
                currentNumber += 1; // Increment the number
            }
        }

        return lexicographicalNumbers;
    }
}