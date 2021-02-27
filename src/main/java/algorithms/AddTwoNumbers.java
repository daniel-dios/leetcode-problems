package algorithms;

import java.util.ArrayList;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 * <p>
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 * <p>
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class AddTwoNumbers {

  private AddTwoNumbers() {
    // Problem class
  }

  public static ListNode solve(ListNode l1, ListNode l2) {
    var carry = 0;
    var i = l1.val + l2.val;
    if (i >= 10) {
      carry = 1;
      i -= 10;
    }
    var listNode = new ListNode(i);
    int futureCarry = 0;

    while (l1.next != null || l2.next != null) {
      int sum = 0;
      if (l1.next != null) {
        sum += l1.next.val;
        l1.next = l1.next.next;
      }
      if (l2.next != null) {
        sum += l2.next.val;
        l2.next = l2.next.next;
      }
      sum += carry;
      if (sum >= 10) {
        futureCarry += 1;
        sum -= 10;
      }
      listNode = new ListNode(sum, listNode);
      carry = futureCarry;
      futureCarry = 0;
    }

    if (carry != 0) {
      listNode = new ListNode(carry, listNode);
    }
    return flip(listNode);
  }

  private static ListNode flip(ListNode listNode) {
    final var integers = new ArrayList<Integer>();
    integers.add(listNode.val);
    while (listNode.next != null) {
      integers.add(listNode.next.val);
      listNode.next = listNode.next.next;
    }
    ListNode listNode1 = null;
    for (int i : integers) {
      listNode1 = new ListNode(i, listNode1);
    }
    return listNode1;
  }
}

class ListNode {
  int val;
  ListNode next;

  public ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}
