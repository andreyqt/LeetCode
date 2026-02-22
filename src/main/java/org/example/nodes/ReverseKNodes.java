package org.example.nodes;

/**
 * task: <a href="https://leetcode.com/problems/swap-nodes-in-pairs/description/">Reverse Nodes in k-Group</a><br>
 * time complexity: {@code O(N)}
 * space complexity: {@code O(1)}
 * difficulty: {@code hard}
 */
public class ReverseKNodes {

    public ListNode swapKNodes(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;

        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        curr = head;
        while (count >= k) {
            for (int i = 1; i < k; i++) {
                ListNode next = curr.next;
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }

            prev = curr;
            curr = curr.next;
            count -= k;
        }

        return dummy.next;
    }

}
