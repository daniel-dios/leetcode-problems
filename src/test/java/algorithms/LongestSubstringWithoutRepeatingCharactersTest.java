package algorithms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LongestSubstringWithoutRepeatingCharactersTest {

  private static Stream<Arguments> values() {
    return Stream.of(
        Arguments.of("abcabcbb", 3),
        Arguments.of("abcdefgh", 8),
        Arguments.of("bbbbb", 1),
        Arguments.of("aab", 2),
        Arguments.of("dvdf", 3),
        Arguments.of("pwwkew", 3),
        Arguments.of("", 0),
        Arguments.of(" 1'", 3),
        Arguments.of(" ", 1)
    );
  }

  @ParameterizedTest
  @MethodSource("values")
  void shouldReturnExpected(String string, int expected) {
    final var actual = LongestSubstringWithoutRepeatingCharacters.solve(string);

    assertThat(actual).isEqualTo(expected);
  }
}