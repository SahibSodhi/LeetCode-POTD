import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        List<int[]> mergedList = new ArrayList<>();
        int i = 0, j = 0;

        while (i < n && j < m) {
            if (nums1[i][0] < nums2[j][0]) {
                mergedList.add(new int[]{nums1[i][0], nums1[i][1]});
                i++;
            } else if (nums1[i][0] > nums2[j][0]) {
                mergedList.add(new int[]{nums2[j][0], nums2[j][1]});
                j++;
            } else {
                mergedList.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            }
        }

        while (i < n) {
            mergedList.add(new int[]{nums1[i][0], nums1[i][1]});
            i++;
        }

        while (j < m) {
            mergedList.add(new int[]{nums2[j][0], nums2[j][1]});
            j++;
        }

        return mergedList.toArray(new int[mergedList.size()][]);
    }
}