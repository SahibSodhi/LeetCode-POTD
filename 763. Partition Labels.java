class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        int n = s.length();
        int prevIndex = -1;
        int maxIndex = 0;
        List<Integer> answer = new ArrayList<>();

        for(int i = 0; i < n; i++){
            mp.put(s.charAt(i), i);
        }

        for(int i = 0; i < n; i++){
            maxIndex = Math.max(maxIndex, mp.get(s.charAt(i)));
            if(maxIndex == i){
                answer.add(maxIndex - prevIndex);
                prevIndex = maxIndex;
            }
        }

        return answer;
    }
}