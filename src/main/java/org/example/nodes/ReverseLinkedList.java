package org.example.nodes;

/**
 * task: <a href="https://leetcode.com/problems/reverse-linked-list/description/">Reverse Linked List</a><br>
 * time complexity: {@code O(N)}
 * space complexity: {@code O(1)}
 * difficulty: {@code easy}
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }

        return prev;
    }

}
