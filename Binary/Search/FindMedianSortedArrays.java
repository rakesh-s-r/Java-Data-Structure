package Binary.Search;

import java.util.Arrays;

public class FindMedianSortedArrays {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[] { 1, 3, 8 }, new int[] { 7, 9, 10, 11 }));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] small = nums1.length <= nums2.length ? nums1 : nums2;
        int[] large = nums1.length <= nums2.length ? nums2 : nums1;
        int n = (small.length + large.length);
        int left = 0, right = small.length;
        System.out.println(Arrays.toString(small));
        System.out.println(Arrays.toString(large));
        while (left <= right) {
            int x = (left + right) / 2;
            int y = ((n + 1) / 2) - x;

            int l1 = x == 0 ? Integer.MIN_VALUE : small[x - 1];
            int r1 = x == small.length ? Integer.MAX_VALUE : small[x];

            int l2 = y == 0 ? Integer.MIN_VALUE : large[y - 1];
            int r2 = y == large.length ? Integer.MAX_VALUE : large[y];

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }
            } else if (l1 < l2) {
                left = x + 1;
            } else {
                right = x - 1;
            }
        }
        return -1;
    }
}
