import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
        );

        // Add the first node of each non-empty list
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {
            ListNode current = pq.poll();

            tail.next = current;
            tail = tail.next;

            // Add the next node from the same list
            if (current.next != null) {
                pq.offer(current.next);
            }
        }

        return dummy.next;
    }
}