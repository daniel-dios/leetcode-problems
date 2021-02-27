package algorithms;

import java.util.HashSet;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * Example 4:
 * <p>
 * Input: s = ""
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubstringWithoutRepeatingCharacters {
  private LongestSubstringWithoutRepeatingCharacters() {
    // Problem class
  }

  public static int solve(String s) {
    var length = s.length();
    var charSet = new HashSet<>();
    var maxSize = 0;
    var forward = 0;
    var backward = 0;

    while (Math.max(forward, backward) < length) {
      if (!charSet.contains(s.charAt(forward))) {
        charSet.add(s.charAt(forward++));
        maxSize = Math.max(maxSize, forward - backward);
      } else {
        charSet.remove(s.charAt(backward));
        backward++;
      }
    }
    return maxSize;
  }
}
