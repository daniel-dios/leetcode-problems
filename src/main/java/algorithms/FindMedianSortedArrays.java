package algorithms;

import java.util.ArrayList;

public class FindMedianSortedArrays {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
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

  private double getMiddle(ArrayList<Integer> numbers) {
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
