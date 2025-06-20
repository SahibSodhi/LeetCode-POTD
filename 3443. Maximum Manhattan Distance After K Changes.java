public class Solution {
    // //Approach 1 - Step by Step solution
    // //TC: O(n), SC: O(1)
    // public int maxDistance(String s, int k) {
    //     int ans = 0;
    //     int north = 0, south = 0, east = 0, west = 0;
    //     for (char it : s.toCharArray()) {
    //         switch (it) {
    //             case 'N':
    //                 north++;
    //                 break;
    //             case 'S':
    //                 south++;
    //                 break;
    //             case 'E':
    //                 east++;
    //                 break;
    //             case 'W':
    //                 west++;
    //                 break;
    //         }
    //         int times1 = Math.min(Math.min(north, south), k); // modification times for N and S
    //         int times2 = Math.min(Math.min(east, west), k - times1); // modification times for E and W
    //         ans = Math.max(
    //             ans,
    //             count(north, south, times1) + count(east, west, times2)
    //         );
    //     }
    //     return ans;
    // }

    // private int count(int drt1, int drt2, int times) {
    //     return Math.abs(drt1 - drt2) + times * 2; // Calculate modified Manhattan distance
    // }

    //Approach 2 - Overall Solution
    //TC: O(n), SC: O(1)
    public int maxDistance(String s, int k) {
        int latitude = 0, longitude = 0, ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'N':
                    latitude++;
                    break;
                case 'S':
                    latitude--;
                    break;
                case 'E':
                    longitude++;
                    break;
                case 'W':
                    longitude--;
                    break;
            }
            ans = Math.max(
                ans,
                Math.min(
                    Math.abs(latitude) + Math.abs(longitude) + k * 2,
                    i + 1
                )
            );
        }
        return ans;
    }
}