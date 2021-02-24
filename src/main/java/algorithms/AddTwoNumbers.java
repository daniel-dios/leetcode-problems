package algorithms;

import java.util.ArrayList;

public class AddTwoNumbers {

  public AddTwoNumbers() {
    // Problem class
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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

  private ListNode flip(ListNode listNode) {
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
