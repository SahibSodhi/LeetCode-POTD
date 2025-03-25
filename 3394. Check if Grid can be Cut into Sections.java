import java.util.*;

class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        //Line Sweep Algorithm on x-axis and y-axis
        List<int[]> xCoordinates = new ArrayList<>();
        List<int[]> yCoordinates = new ArrayList<>();

        for(int[] rectangle : rectangles){
            xCoordinates.add(new int[]{rectangle[0], 1});
            xCoordinates.add(new int[]{rectangle[2], 0});
            yCoordinates.add(new int[]{rectangle[1], 1});
            yCoordinates.add(new int[]{rectangle[3], 0});
        }

        xCoordinates.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        yCoordinates.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        return countLineCuts(xCoordinates) || countLineCuts(yCoordinates);
    }

    public static boolean countLineCuts(List<int[]> coordinates){
        int lines = 0;
        int overlap = 0;

        for(int[] coordinate : coordinates){
            if(coordinate[1] == 0) overlap--;
            else overlap++;

            if(overlap == 0){
                lines++;
            }
        }

        return lines >= 3;
    }
}