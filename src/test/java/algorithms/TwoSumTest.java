package algorithms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TwoSumTest {


  private static Stream<Arguments> values() {
    return Stream.of(
        Arguments.of(new int[] {1, 2, 3}, 4, new int[] {0, 2}),
        Arguments.of(new int[] {1, 2, 3}, 5, new int[] {1, 2}),
        Arguments.of(new int[] {3, 3}, 6, new int[] {0, 1}),
        Arguments.of(new int[] {1, 2, 3}, 6, new int[] {})
    );
  }

  @ParameterizedTest
  @MethodSource("values")
  void shouldReturnExpectedOutput(int[] nums, int target, int[] expected) {
    final var ints = new TwoSum().twoSum(nums, target);

    assertThat(ints).isEqualTo(expected);
  }
}