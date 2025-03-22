class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        int sum = 0; //dynamic sum used to tell value at each index
        int k = 0;

        for(int i = 0; i < n; i++){
            while(sum + diff[i] < nums[i]){
                if(k == queries.length){// All queries done
                    return -1;
                }

                int start = queries[k][0];
                int end = queries[k][1];
                int val = queries[k][2];
                k++;

                if(end < i) continue; //Skip past update

                //Range update in O(1)
                diff[Math.max(start, i)] += val;
                diff[end + 1] -= val;
            }
            sum += diff[i];
        }

        return k;
    }
}