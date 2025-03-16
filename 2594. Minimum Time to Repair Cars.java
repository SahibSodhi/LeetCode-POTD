import java.util.PriorityQueue;

class Solution {
    // 1. Binary Search Approach - TC: O(n * log(max(ranks) * cars ^ 2)) ~ O(n * log(cars)), SC: O(1)
    public long repairCars(int[] ranks, int cars) {
       long start = Long.MAX_VALUE;
       long end = Long.MIN_VALUE;
       long ans = 0;

       for(int rank : ranks){
        start = Math.min(start, rank);
        end = Math.max(end, rank);
       }

       end = end * cars * cars;

       while(start <= end){
        long mid = start + (end - start)/2;

        if(isCarRepairable(ranks, cars, mid)){
            ans = mid;
            end = mid - 1;
        }
        else {
            start = mid + 1;
        }
       }

       return ans;
    }

    // Function to check if the cars are repairable in the given time
    private boolean isCarRepairable(int[] ranks, int carsToBeRepaired, long time){       long carsRepaired = 0;
        for(int rank : ranks){
            carsRepaired += (long) (Math.sqrt((1.0 * time)/rank));
            if(carsRepaired >= carsToBeRepaired) return true;
        }
        return false;
    }

    //2. Min Heap Approach - TC: O(cars * log n), SC: O(n)
    // public long repairCars(int[] ranks, int cars) {
    //     PriorityQueue<long[]> minHeap = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

    //     // Step 1: Initialize the heap with each mechanic's first car repair time
    //     for (int rank : ranks) {
    //         minHeap.offer(new long[]{rank, rank, 1}); // {time, rank, cars repaired}
    //     }

    //     long lastTime = 0;
        
    //     // Step 2: Assign each car optimally
    //     while (cars-- > 0) {
    //         long[] top = minHeap.poll();
    //         long time = top[0]; // The current minimum time
    //         long rank = top[1];
    //         long carsRepaired = top[2];

    //         lastTime = time; // Update the answer with the last repair time

    //         // Calculate the time for the next car this mechanic repairs
    //         long nextTime = rank * (carsRepaired + 1) * (carsRepaired + 1);
    //         minHeap.offer(new long[]{nextTime, rank, carsRepaired + 1});
    //     }

    //     return lastTime;
    // }
}