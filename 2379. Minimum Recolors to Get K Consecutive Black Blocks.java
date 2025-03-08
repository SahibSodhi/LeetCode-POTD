class Solution {
    public int minimumRecolors(String blocks, int k) {
        //Fixed size sliding window
        int countOfWhiteBlocks = 0;
        int n = blocks.length();

        for(int i = 0; i < k; i++){
            if(blocks.charAt(i) == 'W') countOfWhiteBlocks++;
        }

        int result = countOfWhiteBlocks;

        for(int i = 1; i < n - k + 1; i++){
            if(blocks.charAt(i - 1) == 'W') countOfWhiteBlocks--;
            if(blocks.charAt(i + k - 1) == 'W') countOfWhiteBlocks++;

            result = Math.min(result, countOfWhiteBlocks);
        }

        return result;
    }
}