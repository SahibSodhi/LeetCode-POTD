class Solution {

    public long coloredCells(int n) {
        // Mathematical series formed is 1 + (...4 * (n-3) + 4 * (n-2) + 4 * (n-1))
        // Simplifying this series gives us 1 + 2 * n * (n-1)
        return 1 + (long) 2 * n * (n - 1);
    }
    
    // TC: O (n)
    // public long coloredCells(int n) {
    // long result = 1;
    // long difference = 4;
    // n--;

    // while(n > 0){
    // result += difference;
    // difference += 4;
    // n--;
    // }

    // return result;
    // }
}