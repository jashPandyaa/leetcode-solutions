class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //Create new LL since we will need it
        ListNode dummy = new ListNode(1);

        dummy.next = head; 

        //Initialise front and back pointer at the head of the dummy L.L
        ListNode front = dummy;
        ListNode back = dummy;

        for(int i=0; i<=n; i++){
            //increment front till the given nth number to make it optimal approach
            front = front.next;
        }

        while(front != null){
            front = front.next;
            back = back.next;
        }

        //Now we are correct position so remove nth node
        back.next = back.next.next;


        return dummy.next;
    }
}