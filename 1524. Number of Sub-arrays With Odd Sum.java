class Solution {
    public int numOfSubarrays(int[] arr) {
       int MOD = 1000000007;
       int evenCount = 1;
       int oddCount = 0;
       int prefixSum = 0;
       int result = 0;

       for(int num : arr){
        prefixSum += num;
        if(prefixSum %2 == 0){
            result = (result + oddCount) % MOD;
            evenCount++;
        }
        else {
            result = (result + evenCount) % MOD;
            oddCount++;
        }
       }
       
       return result; 
    }
}