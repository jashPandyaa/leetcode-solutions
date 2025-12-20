class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //Create a dummy LinkedList
        ListNode dummy = new ListNode();
        //curr points to null at start
        ListNode cur = dummy;

        //Increment positions of lists untill we reach at either of lists null value
        while (list1 != null && list2 != null) {
            //whichever is minimum , insert that value in curr.next 
            if (list1.val > list2.val) {
                cur.next = list2;
                list2 = list2.next;
            } else {
                cur.next = list1;
                list1 = list1.next;
            }
            //Increment curr to be at the postion to insert next node
            cur = cur.next;
        }

        //For remaining element in either of the lists 
        cur.next = (list1 != null) ? list1 : list2;

        return dummy.next;        
    }
}