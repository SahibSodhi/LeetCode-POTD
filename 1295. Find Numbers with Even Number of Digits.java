class Solution {
    // Approach 4 - Using Constraint Analysis/Range Check
    // Time Complexity: O(N), where N is the number of elements in the array.
    // Space Complexity: O(1), as we are using a constant amount of space.
    public int findNumbers(int[] nums) {
        // Counter to count the number of even digit integers
        int evenDigitCount = 0;

        for (int num : nums) {
            if ((num >= 10 && num <= 99) || (num >= 1000 && num <= 9999) || num == 100000)
                evenDigitCount++;
        }

        return evenDigitCount;
    }

    // // Approach 3 - Using Logarithm
    // // Time Complexity: O(N * log M), where N is the number of elements in the
    // array
    // // and M is the maximum integer in nums.
    // // Space Complexity: O(1), as we are using a constant amount of space.
    // class Solution {
    // public int findNumbers(int[] nums) {
    // // Counter to count the number of even digit integers
    // int evenDigitCount = 0;

    // for (int num : nums) {
    // // Compute the number of digits in the num
    // int digitCount = (int) Math.floor(Math.log10(num)) + 1;
    // if (digitCount % 2 == 0)
    // evenDigitCount++;
    // }

    // return evenDigitCount;
    // }
    // }

    // Approach 2 - Using String Conversion
    // Time Complexity: O(N * log M), where N is the number of elements in the array
    // and M is the maximum integer in nums.
    // Space Complexity: O(logM), as we are storing the string representation of the
    // number.
    // public int findNumbers(int[] nums) {
    // // Counter to count the number of even digit integers
    // int evenDigitCount = 0;

    // for (int num : nums) {
    // // Convert num to string and find its length
    // int length = String.valueOf(num).length();
    // if (length % 2 == 0)
    // evenDigitCount++;
    // }

    // return evenDigitCount;
    // }

    // //Approach 1 - Extract digits using division
    // //Time Complexity: O(N * log M), where N is the number of elements in the
    // array and M is the maximum integer in nums.
    // //Space Complexity: O(1), as we are using a constant amount of space.
    // // Helper function to check if the number of digits is even
    // private boolean hasEvenDigits(int num) {
    // int digitCount = 0;
    // while (num != 0) {
    // digitCount++;
    // num /= 10;
    // }
    // return (digitCount & 1) == 0;
    // }

    // public int findNumbers(int[] nums) {
    // // Counter to count the number of even digit integers
    // int evenDigitCount = 0;

    // for (int num : nums) {
    // if (hasEvenDigits(num))
    // evenDigitCount++;
    // }

    // return evenDigitCount;
    // }
}