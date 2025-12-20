public class Solution {
    public boolean hasCycle(ListNode head) {
        // Edge case
        if(head == null){
            return false;
        }

        // Start both at head
        ListNode slow = head;
        ListNode fast = head;  

        // Continue while fast can move two steps
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            // Cycle detected when pointers meet
            if(fast == slow){
                return true;
            }
        }

        return false;  // No cycle - reached end
    }
}