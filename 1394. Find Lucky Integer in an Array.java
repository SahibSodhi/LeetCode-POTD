class Solution {
    //TC: O(n), SC: O(501) = O(1)
    public int findLucky(int[] arr) {
        int n = arr.length;
        int[] frequency = new int[501];
        int maximumFrequency = -1;

        for(int i = 0; i < n; i++){
            frequency[arr[i]]++;
        }

        for(int i = 0; i < n; i++){
            if(frequency[arr[i]] == arr[i]) {
                maximumFrequency = Math.max(maximumFrequency, frequency[arr[i]]);
            }
        }

        return maximumFrequency;
    }
}