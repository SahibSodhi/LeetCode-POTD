class Solution {
    // //Approach 1 - Enumeration
    // //TC: O(d^2 log(num)), SC: O(1)
    // public int maxDiff(int num) {
    //     int min_num = num;
    //     int max_num = num;
    //     for (int x = 0; x < 10; ++x) {
    //         for (int y = 0; y < 10; ++y) {
    //             String res = change(num, x, y);
    //             // Check if there are leading zeros
    //             if (res.charAt(0) != '0') {
    //                 int res_i = Integer.parseInt(res);
    //                 min_num = Math.min(min_num, res_i);
    //                 max_num = Math.max(max_num, res_i);
    //             }
    //         }
    //     }

    //     return max_num - min_num;
    // }

    // public String change(int num, int x, int y) {
    //     StringBuffer num_s = new StringBuffer(String.valueOf(num));
    //     int length = num_s.length();

    //     for (int i = 0; i < length; i++) {
    //         char digit = num_s.charAt(i);
    //         if (digit - '0' == x) {
    //             num_s.setCharAt(i, (char) ('0' + y));
    //         }
    //     }
    //     return num_s.toString();
    // }

    //Approach 2 - Greedy
    //TC: O(log(num)), SC: O(1)
    public int maxDiff(int num) {
        StringBuffer min_num = new StringBuffer(String.valueOf(num));
        StringBuffer max_num = new StringBuffer(String.valueOf(num));

        // Find a high position and replace it with 9.
        int max_length = max_num.length();
        for (int i = 0; i < max_length; ++i) {
            char digit = max_num.charAt(i);
            if (digit != '9') {
                replace(max_num, digit, '9');
                break;
            }
        }

        // Replace the most significant bit with 1
        // Or find a high-order digit that is not equal to the highest digit and replace it with 0.
        int min_length = min_num.length();
        for (int i = 0; i < min_length; ++i) {
            char digit = min_num.charAt(i);
            if (i == 0) {
                if (digit != '1') {
                    replace(min_num, digit, '1');
                    break;
                }
            } else {
                if (digit != '0' && digit != min_num.charAt(0)) {
                    replace(min_num, digit, '0');
                    break;
                }
            }
        }

        return (
            Integer.parseInt(max_num.toString()) -
            Integer.parseInt(min_num.toString())
        );
    }

    public void replace(StringBuffer s, char x, char y) {
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            if (s.charAt(i) == x) {
                s.setCharAt(i, y);
            }
        }
    }
}