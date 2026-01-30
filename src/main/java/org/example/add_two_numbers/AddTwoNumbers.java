package org.example.add_two_numbers;

/**
 * task: <a href="https://leetcode.com/problems/add-two-numbers/description/">Add Two Numbers</a><br>
 * time complexity: {@code Max(M,N)}<br>
 * space complexity: {@code Max(M,N)}<br>
 * difficulty: {@code medium}
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        int res = 0;

        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = x + y + res;
            res = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;

            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }

        if (res > 0) {
            current.next = new ListNode(res);
        }

        return head.next;
    }

}
