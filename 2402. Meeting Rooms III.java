class Solution {
    // //Approach 1 - Sorting and Counting
    // //TC: O(M⋅logM + M⋅N); SC: O(N + logN)
    // public int mostBooked(int n, int[][] meetings) {
    //     long[] roomAvailabilityTime = new long[n];
    //     int[] meetingCount = new int[n];
    //     Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

    //     for (int[] meeting : meetings) {
    //         int start = meeting[0], end = meeting[1];
    //         long minRoomAvailabilityTime = Long.MAX_VALUE;
    //         int minAvailableTimeRoom = 0;
    //         boolean foundUnusedRoom = false;

    //         for (int i = 0; i < n; i++) {
    //             if (roomAvailabilityTime[i] <= start) {
    //                 foundUnusedRoom = true;
    //                 meetingCount[i]++;
    //                 roomAvailabilityTime[i] = end;
    //                 break;
    //             }

    //             if (minRoomAvailabilityTime > roomAvailabilityTime[i]) {
    //                 minRoomAvailabilityTime = roomAvailabilityTime[i];
    //                 minAvailableTimeRoom = i;
    //             }
    //         }

    //         if (!foundUnusedRoom) {
    //             roomAvailabilityTime[minAvailableTimeRoom] += end - start;
    //             meetingCount[minAvailableTimeRoom]++;
    //         }
    //     }

    //     int maxMeetingCount = 0, maxMeetingCountRoom = 0;
    //     for (int i = 0; i < n; i++) {
    //         if (meetingCount[i] > maxMeetingCount) {
    //             maxMeetingCount = meetingCount[i];
    //             maxMeetingCountRoom = i;
    //         }
    //     }

    //     return maxMeetingCountRoom;
    // }

    //Approach 2 - Sorting, Counting using Priority Queues
    //TC: O(M⋅logM + M⋅logN); SC: O(N + logN)
    public int mostBooked(int n, int[][] meetings) {
        var meetingCount = new int[n];
        var usedRooms = new PriorityQueue<long[]>((a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));
        var unusedRooms = new PriorityQueue<Integer>();

        for (int i = 0; i < n; i++) {
            unusedRooms.offer(i);
        }

        Arrays.sort(meetings, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];

            while (!usedRooms.isEmpty() && usedRooms.peek()[0] <= start) {
                int room = (int) usedRooms.poll()[1];
                unusedRooms.offer(room);
            }

            if (!unusedRooms.isEmpty()) {
                int room = unusedRooms.poll();
                usedRooms.offer(new long[]{end, room});
                meetingCount[room]++;
            } else {
                long roomAvailabilityTime = usedRooms.peek()[0];
                int room = (int) usedRooms.poll()[1];
                usedRooms.offer(new long[]{roomAvailabilityTime + end - start, room});
                meetingCount[room]++;
            }
        }

        int maxMeetingCount = 0, maxMeetingCountRoom = 0;
        for (int i = 0; i < n; i++) {
            if (meetingCount[i] > maxMeetingCount) {
                maxMeetingCount = meetingCount[i];
                maxMeetingCountRoom = i;
            }
        }

        return maxMeetingCountRoom;
    }
}