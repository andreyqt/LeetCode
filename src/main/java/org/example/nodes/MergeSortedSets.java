package org.example.nodes;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * task: <a href="https://leetcode.com/problems/merge-k-sorted-lists/description/">Merge k Sorted Lists</a><br>
 * difficulty: {@code hard}
 */
public class MergeSortedSets {

    /**
     * time complexity: {@code O(N*Log(K)}<br>
     * space complexity: {@code O(K)}<br>
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        for (ListNode node : lists) {
            if (node != null) {
                heap.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!heap.isEmpty()) {
            ListNode minNode = heap.poll();
            tail.next = minNode;
            tail = minNode;

            if (minNode.next != null) {
                heap.offer(minNode.next);
            }
        }
        return dummy.next;
    }

    /**
     * time complexity: {@code O(N*Log(K)}<br>
     * space complexity: {@code O(Log(K))}<br>
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeLists(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int mid = (start + end) / 2;
        ListNode l1 = mergeLists(lists, start, mid);
        ListNode l2 = mergeLists(lists, mid + 1, end);
        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

}
