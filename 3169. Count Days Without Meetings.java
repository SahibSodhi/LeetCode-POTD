import java.util.*;

class Solution {
    //Approach 1 - Sort meetings by start time and use currentStart and currentEnd to track prev interval start and end times
    //TC: O(nlogn), SC: O(1) 
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        int meetingDaysCount = 0;
        int currentStart = -1, currentEnd = -1;

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];
            if (start > currentEnd) {
                if (currentEnd != -1) {
                    meetingDaysCount += (currentEnd - currentStart + 1);
                }
                currentStart = start;
                currentEnd = end;
            } else {//Merging the intervals
                currentEnd = Math.max(currentEnd, end);
            }
        }

        if (currentEnd != -1) {
            meetingDaysCount += (currentEnd - currentStart + 1);
        }

        return days - meetingDaysCount;
    }

    // Approach 2 - Sort the meetings by start time and merge the overlapping meetings
    // //TC: O(nlogn), SC: O(n)  
    // public int countDays(int days, int[][] meetings) {
    //     Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

    //     List<int[]> mergedMeetings = new ArrayList<>();

    //     for (int[] meeting : meetings) {
    //         if (mergedMeetings.isEmpty() || meeting[0] > mergedMeetings.get(mergedMeetings.size() - 1)[1]) {
    //             mergedMeetings.add(meeting);
    //         } else {
    //             mergedMeetings.get(mergedMeetings.size() - 1)[1] = 
    //                 Math.max(mergedMeetings.get(mergedMeetings.size() - 1)[1], meeting[1]);
    //         }
    //     }

    //     int meetingDaysCount = 0;
    //     for (int[] m : mergedMeetings) {
    //         meetingDaysCount += (m[1] - m[0] + 1);
    //     }

    //     return days - meetingDaysCount;
    // }
}