package algorithms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class AddTwoNumbersTest {

  private static Stream<Arguments> values() {
    return Stream.of(
        Arguments.of(
            getListNode(2, 4, 3),
            getListNode(5, 6, 4),
            getListNode(7, 0, 8)
        ),
        Arguments.of(
            getListNode(9, 9, 9),
            getListNode(1),
            getListNode(0, 0, 0, 1)
        ),
        Arguments.of(
            getListNode(
                9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
                9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
                9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9),
            getListNode(1),
            getListNode(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                1)
        )
    );
  }

  private static ListNode getListNode(int... ints) {
    ListNode listNode = null;
    for (int j = ints.length - 1; j >= 0; j--) {
      int i = ints[j];
      listNode = new ListNode(i, listNode);
    }
    return listNode;
  }

  @ParameterizedTest
  @MethodSource("values")
  void shouldReturnExpected(ListNode l1, ListNode l2, ListNode expected) {

    final var actual = AddTwoNumbers.solve(l1, l2);

    assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
  }
}
