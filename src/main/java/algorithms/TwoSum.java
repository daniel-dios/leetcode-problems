package algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 * <p>
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 * <p>
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 103
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 */
public class TwoSum {
  public TwoSum() {
    // problem class
  }

  public int[] twoSum(int[] nums, int target) {

    Map<Integer, Integer> goodNumbers = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      if (goodNumbers.containsKey(target - nums[i])) {
        return new int[] {goodNumbers.get(target - nums[i]), i};
      }
      goodNumbers.put(nums[i], i);
    }

    return new int[] {};
  }
}
