public class Solution {
    //Approach 2 - Enumerate all 3 digit even numbers
    //TC: O(900 * d) = O(900) = O(1) (We check at most 900 numbers, and digit frequency comparison is constant since max 10 digits)
    //SC: O(1) (Fixed-size frequency maps, output list of at most 900 numbers)

    public int[] findEvenNumbers(int[] digits) {
        int[] freq = new int[10];
        for (int d : digits) freq[d]++;

        List<Integer> res = new ArrayList<>();

        for (int i = 100; i <= 998; i += 2) {
            int a = i / 100, b = (i / 10) % 10, c = i % 10;
            int[] local = new int[10];
            local[a]++;
            local[b]++;
            local[c]++;
            boolean valid = true;
            for (int d = 0; d < 10; d++) {
                if (local[d] > freq[d]) {
                    valid = false;
                    break;
                }
            }
            if (valid) res.add(i);
        }

        int[] result = new int[res.size()];

        for (int i = 0; i < res.size(); ++i) {
            result[i] = res.get(i);
        }

        return result;
    }

    // //Approach 1 - Brute Force
    // //TC: O(n^3), SC: O(n) 
    // public int[] findEvenNumbers(int[] digits) {
    //     Set<Integer> nums = new HashSet<>();
    //     int n = digits.length;

    //     // Traverse the indices of three digits
    //     for (int i = 0; i < n; ++i) {
    //         for (int j = 0; j < n; ++j) {
    //             for (int k = 0; k < n; ++k) {
    //                 // Determine whether it meets the condition of the target even number
    //                 if (i == j || j == k || i == k) {
    //                     continue;
    //                 }

    //                 int num = digits[i] * 100 + digits[j] * 10 + digits[k];

    //                 if (num >= 100 && num % 2 == 0) {
    //                     nums.add(num);
    //                 }
    //             }
    //         }
    //     }

    //     // Converted to an array sorted in ascending order
    //     List<Integer> res = new ArrayList<>(nums);

    //     Collections.sort(res);
    //     int[] result = new int[res.size()];

    //     for (int i = 0; i < res.size(); ++i) {
    //         result[i] = res.get(i);
    //     }

    //     return result;
    // }
}