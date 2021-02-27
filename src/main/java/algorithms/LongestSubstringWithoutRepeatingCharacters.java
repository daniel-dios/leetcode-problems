package algorithms;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
  public LongestSubstringWithoutRepeatingCharacters() {
    // Problem class
  }

  public int lengthOfLongestSubstring(String s) {
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
