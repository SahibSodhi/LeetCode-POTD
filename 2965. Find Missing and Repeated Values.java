class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int sq = n * n;
        int[] unique = new int[sq + 1]; //Can use set also but array is fast than set even though both have same time and space complexity

        int sum = 0;
        int[] result = new int[2];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(unique[grid[i][j]] != 0){
                    result[0] = grid[i][j];
                }
                else {
                    unique[grid[i][j]] = 1;
                    sum += grid[i][j];
                }
            }
        }

        result[1] = (sq * (sq + 1)/2) - sum;

        return result;
    }
}