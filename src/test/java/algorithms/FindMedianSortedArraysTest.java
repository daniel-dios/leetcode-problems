package algorithms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindMedianSortedArraysTest {

  private static Stream<Arguments> values() {
    return Stream.of(
        Arguments.of(new int[] {1, 2, 3}, new int[] {0, 2}, 2.00000),
        Arguments.of(new int[] {1, 2}, new int[] {3, 4}, 2.50000),
        Arguments.of(new int[] {0, 0}, new int[] {0, 0}, 0.00000),
        Arguments.of(new int[] {}, new int[] {1}, 1.00000)
    );
  }

  @ParameterizedTest
  @MethodSource("values")
  void shouldReturnExpectedOutput(int[] nums1, int[] nums2, double expected) {
    final double actual = FindMedianSortedArrays.solve(nums1, nums2);

    assertThat(actual).isEqualTo(expected);
  }
}