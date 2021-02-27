package algorithms;

import java.util.ArrayList;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 * <p>
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * Example 3:
 * <p>
 * Input: nums1 = [0,0], nums2 = [0,0]
 * Output: 0.00000
 * Example 4:
 * <p>
 * Input: nums1 = [], nums2 = [1]
 * Output: 1.00000
 * Example 5:
 * <p>
 * Input: nums1 = [2], nums2 = []
 * Output: 2.00000
 * <p>
 * <p>
 * Constraints:
 * <p>
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class FindMedianSortedArrays {

  private FindMedianSortedArrays() {
    // Problem class
  }

  public static double solve(int[] nums1, int[] nums2) {
    final var numbers = new ArrayList<Integer>();
    final var length1 = nums1.length;
    final var length2 = nums2.length;

    var i = 0;
    var j = 0;

    while (i < length1 || j < length2) {
      if (i >= length1) {
        numbers.add(nums2[j]);
        j++;
      } else if (j >= length2) {
        numbers.add(nums1[i]);
        i++;
      } else if (nums1[i] < nums2[j]) {
        numbers.add(nums1[i]);
        i++;
      } else {
        numbers.add(nums2[j]);
        j++;
      }
    }

    return getMiddle(numbers);
  }

  private static double getMiddle(ArrayList<Integer> numbers) {
    if (numbers.isEmpty()) {
      return 0.00000;
    }
    if (numbers.size() == 1) {
      return numbers.get(0);
    }
    if (numbers.size() % 2 != 0) {
      return (double) numbers.get(numbers.size() / 2);
    }
    final var i = numbers.get(numbers.size() / 2);
    final var j = numbers.get((numbers.size() / 2) - 1);
    return (double) (i + j) / 2.00000;
  }
}
