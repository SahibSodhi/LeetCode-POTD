class Solution {
    //TC: O(n), SC: O(n)
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : answers) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        int total = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int x = entry.getKey(); // Rabbit said "x others"
            int freq = entry.getValue(); // how many rabbits gave this answer

            int groupSize = x + 1;
            int groups = (int) Math.ceil((double) freq / groupSize);

            total += groups * groupSize;
        }

        return total;
    }
}