class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        //When curr reaches at the null , reverse the LinkedList
        while(curr != null){
            //Temp variable to store curr's next node
            ListNode temp = curr.next;
            //Flip the values of curr and prev pointers
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        //We can't return curr since it points towards null at the end and prev keeps the last node
        return prev;
    }
}