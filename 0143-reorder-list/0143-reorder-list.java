class Solution {
    public void reorderList(ListNode head) {
        if( head == null){
            return;
        }

        ListNode slow = head, fast = head;

        //To find the middle node of LL
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //We will create new LL starting from the slow pointer
        ListNode prev = null , curr = slow;
        ListNode temp;

        //To reverse the Second LL
        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp; 
        }

        //We do have reverse second LL. So just merge the first and second LL
        ListNode first = head , second = prev;   // prev bcoz curr will point to the null
        
        while(second.next != null){
            //First take main LL's value than second LL and move further respectively...
            temp = first.next;
            first.next = second;
            first = temp;

            temp = second.next;
            second.next = first;
            second = temp;
        }

        
    }
}