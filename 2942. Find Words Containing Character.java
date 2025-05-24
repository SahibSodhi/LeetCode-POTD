class Solution {
    //TC: O(n * m) // n is the length of the array and m is the length of the string
    //SC: O(1)
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> indices = new ArrayList<>();

        for(int word = 0; word < words.length; word++){
            if(words[word].indexOf(x) != -1){
                indices.add(word);
            }
        }

        return indices;
    }
}