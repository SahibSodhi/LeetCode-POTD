class Solution {
    //Approach 1 - Binary Search + Binary Search
    //TC: O(n1 logn2 logC), SC: O(1); C = 2 * 10^10 + 1 is the size of the range of the product of the two array elements required by the problem.

    // int f(int[] nums2, long x1, long v) {
    //     int n2 = nums2.length;
    //     int left = 0, right = n2 - 1;
    //     while (left <= right) {
    //         int mid = (left + right) / 2;
    //         long prod = (long) nums2[mid] * x1;
    //         if ((x1 >= 0 && prod <= v) || (x1 < 0 && prod > v)) {
    //             left = mid + 1;
    //         } else {
    //             right = mid - 1;
    //         }
    //     }
    //     if (x1 >= 0) {
    //         return left;
    //     } else {
    //         return n2 - left;
    //     }
    // }

    // public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
    //     int n1 = nums1.length;
    //     long left = -10000000000L, right = 10000000000L;

    //     while (left <= right) {
    //         long mid = (left + right) / 2;
    //         long count = 0;
    //         for (int i = 0; i < n1; i++) {
    //             count += f(nums2, nums1[i], mid);
    //         }
    //         if (count < k) {
    //             left = mid + 1;
    //         } else {
    //             right = mid - 1;
    //         }
    //     }
    //     return left;
    // }

    //Approach 2 - Binary Search + Divide and Conquer
    //TC: O((n1 + n2) logC), SC: O(1); C = 2 * 10^10 + 1 is the size of the range of the product of the two array elements required by the problem.

    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        int n1 = nums1.length, n2 = nums2.length;
        int pos1 = 0, pos2 = 0;
        while (pos1 < n1 && nums1[pos1] < 0) {
            pos1++;
        }
        while (pos2 < n2 && nums2[pos2] < 0) {
            pos2++;
        }
        long left = (long) -1e10, right = (long) 1e10;
        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;
            int i1 = 0, i2 = pos2 - 1;
            while (i1 < pos1 && i2 >= 0) {
                if ((long) nums1[i1] * nums2[i2] > mid) {
                    i1++;
                } else {
                    count += pos1 - i1;
                    i2--;
                }
            }
            i1 = pos1;
            i2 = n2 - 1;
            while (i1 < n1 && i2 >= pos2) {
                if ((long) nums1[i1] * nums2[i2] > mid) {
                    i2--;
                } else {
                    count += i2 - pos2 + 1;
                    i1++;
                }
            }
            i1 = 0;
            i2 = pos2;
            while (i1 < pos1 && i2 < n2) {
                if ((long) nums1[i1] * nums2[i2] > mid) {
                    i2++;
                } else {
                    count += n2 - i2;
                    i1++;
                }
            }
            i1 = pos1;
            i2 = 0;
            while (i1 < n1 && i2 < pos2) {
                if ((long) nums1[i1] * nums2[i2] > mid) {
                    i1++;
                } else {
                    count += n1 - i1;
                    i2++;
                }
            }
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}