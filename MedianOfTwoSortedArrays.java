package LeetCode100;

/**
 * 4. Median of Two Sorted Arrays
 * https://www.youtube.com/watch?time_continue=654&v=LPFhl65R7ww
 * 二分查找，long(min(m, n))
 * 重点：
 * x: x1 x2 x3| x4 x5
 * y: y1 y2 y3| y4 y5 6
 * 在x中找到划分点partitionX,在y中找到划分点partitionY，使得x3 <= y4, y3 <= x4
 * 同时partitionX + partitionY = (X + Y + 1) / 2（这里之所以+1是为了保证奇数的时候，通过partition左边的2个点求max即可）
 * 那么就有左边的都小于右边的，于是mid = (x3 + y3) / 2（偶数的话是mid = avg(max(x3, y3), min(x4,y4))）
 * 如果不满足条件，就对小的那个数组进行二分查找即可
 */


public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int X = nums1.length;
        int Y = nums1.length;
        if (X > Y) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int lo = 0, hi = X;
        while (lo <= hi) {
            int partitionX = lo + (hi - lo) / 2;
            int partitionY = (X + Y + 1) / 2 - partitionX;
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == X) ? Integer.MAX_VALUE : nums1[partitionX];
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == Y) ? Integer.MAX_VALUE : nums2[partitionY];
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((X + Y) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                hi = partitionX - 1;
            } else {
                lo = partitionX + 1;
            }
        }
        throw new IllegalArgumentException();
    }
}
