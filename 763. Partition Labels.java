class Solution {
    //Approach 2 - Array of constant size
    public List<Integer> partitionLabels(String s) {
        // Stores the last index of each character in 's'
        int[] lastOccurrence = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }

        int partitionEnd = 0, partitionStart = 0;
        List<Integer> partitionSizes = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            partitionEnd = Math.max(
                partitionEnd,
                lastOccurrence[s.charAt(i) - 'a']
            );
            // End of the current partition
            if (i == partitionEnd) {
                partitionSizes.add(i - partitionStart + 1);
                partitionStart = i + 1;
            }
        }
        return partitionSizes;
    }

    //Approach 1 - HashMap
    // public List<Integer> partitionLabels(String s) {
    //     Map<Character, Integer> mp = new HashMap<>();
    //     int n = s.length();
    //     int prevIndex = -1;
    //     int maxIndex = 0;
    //     List<Integer> answer = new ArrayList<>();

    //     for(int i = 0; i < n; i++){
    //         mp.put(s.charAt(i), i);
    //     }

    //     for(int i = 0; i < n; i++){
    //         maxIndex = Math.max(maxIndex, mp.get(s.charAt(i)));
    //         if(maxIndex == i){
    //             answer.add(maxIndex - prevIndex);
    //             prevIndex = maxIndex;
    //         }
    //     }

    //     return answer;
    // }
}