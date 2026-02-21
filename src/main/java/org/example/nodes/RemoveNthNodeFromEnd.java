package org.example.nodes;

/**
 * task: <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/">Remove Nth Node From End of List</a><br>=
 * time complexity: {@code O(N)}
 * space complexity: {@code O(1)}
 * difficulty: {@code medium}
 */
public class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return dummy.next;
    }

}
