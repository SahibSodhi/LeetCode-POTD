class Solution {
    // //Approach 1 - Brute Force
    // // Time Complexity: O(n)
    // // Space Complexity: O(1)
    // public boolean threeConsecutiveOdds(int[] arr) {
    //     // Loop through the array up to the third-to-last element
    //     for (int i = 0; i < arr.length - 2; i++) {
    //         // Check if the current element and the next two elements are all odd
    //         if (arr[i] % 2 == 1 && arr[i + 1] % 2 == 1 && arr[i + 2] % 2 == 1) {
    //             return true;
    //         }
    //     }

    //     return false;
    // }

    // //Approach 2 - Counting
    // // Time Complexity: O(n)
    // // Space Complexity: O(1)
    // public boolean threeConsecutiveOdds(int[] arr) {
    //     int consecutiveOdds = 0;

    //     // Loop through each element in the array
    //     for (int i = 0; i < arr.length; i++) {
    //         // Increment the counter if the number is odd,
    //         // else reset the counter
    //         if (arr[i] % 2 == 1) {
    //             consecutiveOdds++;
    //         } else {
    //             consecutiveOdds = 0;
    //         }

    //         // Check if there are three consecutive odd numbers
    //         if (consecutiveOdds == 3) {
    //             return true;
    //         }
    //     }

    //     return false;
    // }

    //Approach 3  - Product of Three numbers
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public boolean threeConsecutiveOdds(int[] arr) {
        // Loop through the array up to the third-to-last element
        for (int i = 0; i < arr.length - 2; i++) {
            int product = arr[i] * arr[i + 1] * arr[i + 2];
            // Check if the product is odd
            if (product % 2 == 1) return true;
        }
        return false;
    }
}