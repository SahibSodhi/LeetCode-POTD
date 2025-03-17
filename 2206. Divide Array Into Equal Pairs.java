import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        for(int key : freq.keySet()){
            if(freq.get(key) % 2 != 0){
                return false;
            }
        }

        return true;

    }
}