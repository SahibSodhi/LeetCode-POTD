class Solution {
    //Approach 1 - Generate all subsets using Backtracking
    // Time Complexity: O(2^N * N) where N is the length of nums
    // Space Complexity: O(2^N * N) for 2^N subsets with an average size of N/2

    public int subsetXORSum(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        // Generate all of the subsets
        generateSubsets(nums, 0, new ArrayList<>(), subsets);

        // Compute the XOR total for each subset and add to the result
        int result = 0;
        for (List<Integer> subset : subsets) {
            int subsetXORTotal = 0;
            for (int num : subset) {
                subsetXORTotal ^= num;
            }
            result += subsetXORTotal;
        }
        return result;
    }

    private void generateSubsets(int[] nums, int index, List<Integer> subset, List<List<Integer>> subsets) {
        // Base case: index reached end of nums
        // Add the current subset to subsets
        if (index == nums.length) {
            subsets.add(new ArrayList<>(subset));
            return;
        }

        // Generate subsets with nums[i]
        subset.add(nums[index]);
        generateSubsets(nums, index + 1, subset, subsets);
        subset.remove(subset.size() - 1);

        // Generate subsets without nums[i]
        generateSubsets(nums, index + 1, subset, subsets);
    }
}