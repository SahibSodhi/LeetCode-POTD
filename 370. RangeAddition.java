class RangeAddition {
    // Method to compute the modified array after a sequence of updates
    public int[] getModifiedArray(int length, int[][] updates) {
        // Create an array 'difference' initialized to zero, with the given length
        int[] difference = new int[length];

        // Apply each update in the updates array
        for(int[] update : updates){
            int start = update[0];// Start index for the update
            int end = update[1];   // End index for the update
            int value = update[2];  // Value to add to the subarray

            // Apply increment to the start index
            difference[start] += value;

            // If the end index is not the last element,
            // apply the negation of increment to the element after the end index
            if(end + 1 < length){
                difference[end + 1] -= value;
            }
        }

        // Convert the 'difference' array into the actual array 'result'
        // where each element is the cumulative sum from start to that index
        for(int i = 1; i < length; i++){
            difference[i] += difference[i - 1];
        }

        // Return the resultant modified array
        return difference;
    }

    public static void main(String[] args){
        RangeAddition rangeAddition = new RangeAddition();
        int length = 5;
        int[][] updates = {{1, 3, 2}, {2, 4, 3}, {0, 2, -2}};
        int[] result = rangeAddition.getModifiedArray(length, updates);
        for(int i : result){
            System.out.print(i + " ");
        }
    }
}
