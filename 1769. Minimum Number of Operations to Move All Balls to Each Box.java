class Solution {
    // Approach 3 - One pass
    // TC: O(n), SC: O(1)
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];
        int leftCost = 0;
        int leftBalls = 0;
        int rightCost = 0;
        int rightBalls = 0;

        for (int i = 0; i < n; i++) {
            // Left to right pass
            answer[i] += leftCost;
            leftBalls += boxes.charAt(i) == '1' ? 1 : 0;
            leftCost += leftBalls;

            // Right to left pass
            int j = n - 1 - i;
            answer[j] += rightCost;
            rightBalls += boxes.charAt(j) == '1' ? 1 : 0;
            rightCost += rightBalls;
        }

        return answer;
    }

    // //Approach 2 - Two pass
    // //TC: O(n), SC: O(1)
    // public int[] minOperations(String boxes) {
    // int n = boxes.length();
    // int[] answer = new int[n];
    // int leftCost = 0;
    // int leftBalls = 0;
    // int rightCost = 0;
    // int rightBalls = 0;

    // //Left to right pass
    // for(int i = 0; i < n; i++){
    // answer[i] += leftCost;
    // leftBalls += boxes.charAt(i) == '1' ? 1 : 0;
    // leftCost += leftBalls;
    // }

    // //Right to left pass
    // for(int i = n - 1; i >= 0; i--){
    // answer[i] += rightCost;
    // rightBalls += boxes.charAt(i) == '1' ? 1 : 0;
    // rightCost += rightBalls;
    // }

    // return answer;
    // }
    // }

    // //Approach 1 - Brute force
    // //TC: O(n^2), SC: O(1)
    // public int[] minOperations(String boxes) {
    // int n = boxes.length();
    // int[] answer = new int[n];

    // for(int i = 0; i < n; i++){
    // for(int j = 0; j < n; j++){
    // if(j != i && boxes.charAt(j) == '1'){
    // answer[i] += Math.abs(i - j);
    // }
    // }
    // }

    // return answer;
    // }
}