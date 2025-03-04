//Ternary approach - TC - O(log n base 3), SC - O(1)
class Solution {
    public boolean checkPowersOfThree(int n) {
        while(n > 0){
            if(n % 3 == 2){
                return false;
            }
            n /= 3;
        }
        return true;
    }
}

//Backtracking approach - TC - 2^(log n base 3) = O(n). SC - O(log n base 3)
// class Solution {
//     public boolean checkPowersOfThree(int n) {
//         return checkPowersOfThreeHelper(0, n);
//     }

//     private boolean checkPowersOfThreeHelper(int power, int n){
//         if(n == 0) return true;

//         if(n < Math.pow(3, power)){
//             return false;
//         }

//         boolean addPower = checkPowersOfThreeHelper(power + 1, n - (int) Math.pow(3, power));
//         boolean skipPower = checkPowersOfThreeHelper(power + 1, n);

//         return addPower || skipPower;
//     }
// }