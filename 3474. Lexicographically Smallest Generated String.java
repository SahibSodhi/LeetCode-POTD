class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n + m - 1; i++) {
            sb.append('a');
        }

        boolean[] fixed = new boolean[n + m - 1];

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    sb.setCharAt(i + j, str2.charAt(j));
                    fixed[i + j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {
                boolean same = true;
                for (int j = 0; j < m; j++) {
                    if (sb.charAt(i + j) != str2.charAt(j)) {
                        same = false;
                        break;
                    }
                }

                if (same) {
                    for (int j = m - 1; j >= 0; j--) {
                        if (!fixed[i + j]) {
                            sb.setCharAt(i + j, 'b');
                            break;
                        }
                    }
                }
            }
        }

        //Check if the generated string is valid
        for (int i = 0; i < n; i++) {
            boolean same = true;
            for (int j = 0; j < m; j++) {
                if (sb.charAt(i + j) != str2.charAt(j)) {
                    same = false;
                    break;
                }
            }

            if ((str1.charAt(i) == 'T' && !same) || (str1.charAt(i) == 'F' && same)) {
                return "";
            }
        }

        return sb.toString();

    }
}