import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int largestMissing = -1;
        Map<Integer, Integer> frequency = new HashMap<>();

        for(int i = 0; i <= n-k; i++){
            HashSet<Integer> unique = new HashSet<>();
            for(int j = i; j < i + k; j++){
                unique.add(nums[j]);
            }

            for(Integer num : unique){
                frequency.put(num, frequency.getOrDefault(num, 0) + 1);
            }
        }

        for(Integer num : frequency.keySet()){
            if(frequency.get(num) == 1){
                largestMissing = Math.max(largestMissing, num);
            }
        }

        return largestMissing;
    }
}