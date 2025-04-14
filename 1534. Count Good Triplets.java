class Solution {
    // Approach 1 - Using Brute Force
    // Time Complexity - O(n^3)
    // Space Complexity - O(1)
    // public int countGoodTriplets(int[] arr, int a, int b, int c) {
    // int n = arr.length;
    // int count = 0;

    // for(int i = 0; i < n - 2; i++){
    // for(int j = i + 1; j < n - 1; j++){
    // for(int k = j + 1; k < n; k++){
    // if(Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b &&
    // Math.abs(arr[i] - arr[k]) <= c){
    // count++;
    // }
    // }
    // }

    // }

    // return count;
    // }

    // Approach 2 - Using Prefix Sum
    // Time Complexity - O(n^2 + nS) ~ O(n^2); S is the upper limit of the array
    // values, here it is 1000
    // Space Complexity - O(S) ~ O(1000)
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int ans = 0, n = arr.length;
        int[] sum = new int[1001];

        for (int j = 0; j < n; ++j) {
            for (int k = j + 1; k < n; ++k) {
                if (Math.abs(arr[j] - arr[k]) <= b) {
                    int lj = arr[j] - a, rj = arr[j] + a;
                    int lk = arr[k] - c, rk = arr[k] + c;
                    int l = Math.max(0, Math.max(lj, lk));
                    int r = Math.min(1000, Math.min(rj, rk));

                    if (l <= r) {
                        if (l == 0) {
                            ans += sum[r];
                        } else {
                            ans += sum[r] - sum[l - 1];
                        }
                    }
                }
            }

            for (int k = arr[j]; k <= 1000; ++k) {
                ++sum[k];
            }
        }

        return ans;
    }
}