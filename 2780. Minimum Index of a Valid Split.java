class Solution {
    //TC: O(n), SC: O(1)
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        int majorityElement = findMajorityElement(nums);
        int maxFrequency = 0;
        int prefixCount = 0;
        int remainingCount = 0;

        for(int num : nums){
            if(num == majorityElement){
                maxFrequency++;
            }
        }

        for(int index = 0; index < n - 1; index++){
            if(nums.get(index) == majorityElement){
                prefixCount++;
                remainingCount = maxFrequency - prefixCount;
            }

            if(prefixCount > (index + 1)/2 && remainingCount > (n - 1 - index)/2){
                return index;
            }
        }

        return -1;
    }

    //Moore's Voting Algorithm
    private int findMajorityElement(List<Integer> nums){
        int majorityElement = nums.get(0);
        int n = nums.size();
        int count = 1;

        for(int i = 1; i < n; i++){
            if(nums.get(i) == majorityElement){
                count++;
            }
            else {
                count--;
            }

            if(count == 0){
                majorityElement = nums.get(i);
                count = 1;
            }
        }

        return majorityElement;
    }

    //TC: O(n), SC: O(1)
    // public int minimumIndex(List<Integer> nums) {
    //     // Find the majority element
    //     int x = nums.get(0), count = 0, xCount = 0, n = nums.size();

    //     for (int num : nums) {
    //         if (num == x) {
    //             count++;
    //         } else {
    //             count--;
    //         }
    //         if (count == 0) {
    //             x = num;
    //             count = 1;
    //         }
    //     }

    //     // Count frequency of majority element
    //     for (int num : nums) {
    //         if (num == x) {
    //             xCount++;
    //         }
    //     }

    //     // Check if valid split is possible
    //     count = 0;
    //     for (int index = 0; index < n; index++) {
    //         if (nums.get(index) == x) {
    //             count++;
    //         }
    //         int remainingCount = xCount - count;
    //         // Check if both left and right partitions satisfy the condition
    //         if (count * 2 > index + 1 && remainingCount * 2 > n - index - 1) {
    //             return index;
    //         }
    //     }

    //     return -1;
    // }
}