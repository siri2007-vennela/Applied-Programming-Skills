class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupEnd = dummy;
        ListNode curr = head;

        while (true) {
            // Check if there are at least k nodes left
            ListNode check = curr;
            for (int i = 0; i < k; i++) {
                if (check == null) {
                    return dummy.next; // not enough nodes, return result
                }
                check = check.next;
            }

            // Reverse k nodes
            ListNode groupStart = curr;
            ListNode prev = check; // next group's start
            for (int i = 0; i < k; i++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Connect previous group to newly reversed group
            prevGroupEnd.next = prev;
            prevGroupEnd = groupStart;
        }
    }
}
