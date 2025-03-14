class Solution {
    public int maximumCandies(int[] candies, long k) {
        int n = candies.length;
        long sum = 0;

        for(int num : candies){
            sum += num;
        }

        if(sum < k){
            return 0;
        }

        long left = 1; // Start from 1 to avoid mid = 0
        long right = sum/k;
        long ans = 0;

        //Binary search on possible range of answer
        while(left <= right){
            long mid = left + (right - left)/2;

            long count = 0;
            for(int i = 0; i < n; i++){
                count += candies[i]/mid;
            }

            if(count >= k){
                ans = mid;  // No need for Math.max, as mid is always increasing
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return (int)ans;
    }
}