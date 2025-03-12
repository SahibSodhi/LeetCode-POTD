class Solution {
    // Time complexity: O(logn)
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int end = n - 1;
        int negativePos = binarySearch(nums, 0, end, -1);//first occurence of non neg meaning >= 0 means > -1
        int positivePos = binarySearch(nums, negativePos, end, 0);//first occurence of pos meaning > 0
        int positiveCount = n - positivePos;

        return Math.max(negativePos, positiveCount);
    }

    int binarySearch(int[] nums, int start, int end, int target){
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] <= target){
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return start;
    }

    // Time complexity: O(n)
    // public int maximumCount(int[] nums) {
    //     int n = nums.length;
    //     int firstNegative = -1;
    //     int firstPositive = -1;

    //     for(int i = 0; i < n; i++){
    //         if(nums[i] >= 0 && firstNegative == -1){
    //             firstNegative = i;
    //         }

    //         if(nums[i] > 0 && firstPositive == -1){
    //             firstPositive = i;
    //             break;
    //         }
    //     }

    //     firstNegative = (firstNegative == -1) ? n : firstNegative;
    //     firstPositive = (firstPositive == -1) ? 0 : (n - firstPositive);

    //     return Math.max(firstNegative, firstPositive);
    // }

    // Time complexity: O(n)
    // public int maximumCount(int[] nums) {
    //     int negativeCount = 0;
    //     int positiveCount = 0;

    //     for(int num : nums){
    //         if(num < 0){
    //             negativeCount++;
    //         }
    //         else if(num > 0){
    //             positiveCount++;
    //         }
    //     }

    //     return Math.max(negativeCount, positiveCount);
    // }
}