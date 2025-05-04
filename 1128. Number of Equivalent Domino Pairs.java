class Solution {
    // //Approach 1 - Tuple Representation + Counting
    // public int numEquivDominoPairs(int[][] dominoes) {
    //     int[] num = new int[100];
    //     int ret = 0;
    //     for (int[] domino : dominoes) {
    //         int val = domino[0] < domino[1]
    //             ? domino[0] * 10 + domino[1]
    //             : domino[1] * 10 + domino[0];
    //         ret += num[val];
    //         num[val]++;
    //     }
    //     return ret;
    // }

    //Approach 2 - Using Hashmap (Useful if domino values are large)
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        int result = 0;

        for (int[] domino : dominoes) {
            int equi = Math.min(domino[0], domino[1]) * 10 + Math.max(domino[0], domino[1]);
            counter.put(equi, counter.getOrDefault(equi, 0) + 1);
        }

        for(int count: counter.values()){
            result += count * (count - 1) / 2;
        }

        return result;
    }
}