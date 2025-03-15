class Solution {
    public int minCapability(int[] nums, int k) {
        // Binary search on the capability
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        int ans = 0;

        // Find the range of capability
        for(int num : nums){
            start = Math.min(start, num);
            end = Math.max(end, num);
        }

        while(start <= end){
            int mid = start + (end - start)/2;

            // Check if robbery is possible with this capability
            if(isRobberyPossible(nums, mid, k)){
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        return ans;
    }

    public boolean isRobberyPossible(int[] nums, int capability, int minHouses){
        int housesRobbed = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= capability){
                housesRobbed++;
                i++; // skip for adjacent houses condition
            }

            if(housesRobbed >= minHouses) return true;
        }

        return false;
    }
}