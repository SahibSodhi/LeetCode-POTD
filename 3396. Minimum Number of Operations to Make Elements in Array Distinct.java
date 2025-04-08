class Solution {
    //Approach 2 - Traverse array in reverse order and track for seen elements
    //TC: O(n), SC: O(n)
    public int minimumOperations(int[] nums) {
        boolean[] seen = new boolean[128];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (seen[nums[i]]) {
                return i / 3 + 1;
            }
            seen[nums[i]] = true;
        }
        
        return 0;
    }

    // //Approach 1 - Brute force
    // //TC: O(n^2), SC: O(n)
    // public int minimumOperations(int[] nums) {
    //     int ans = 0;
    //     int n =  nums.length;
    //     for(int i = 0; i < n; i+=3, ans++){
    //         if(checkUnique(nums, i)){
    //             return ans;
    //         }
    //     }

    //     return ans;
    // }

    // private boolean checkUnique(int[] nums, int start){
    //     HashSet<Integer> count = new HashSet<>();

    //     for(int i = start; i < nums.length; i++){
    //         if(count.contains(nums[i])){
    //             return false;
    //         }
    //         count.add(nums[i]);
    //     }

    //     return true;
    // }
}