class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int result = 0;
        int left = 0;

        for(int right = 1; right < n + k - 1; right++){
            //skip the subarray
            if(colors[right % n] == colors[(right - 1) % n]){//Using modulo for circular array instead of using extra space for considering circular subarrays
                left = right;
            }
            if(right - left + 1 == k){
                result++;
                left++;
            }
        }

        return result;
    }
}