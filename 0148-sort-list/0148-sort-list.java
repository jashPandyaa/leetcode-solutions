class Solution {
    public ListNode sortList(ListNode head) {
        //Merge Sort + Fast & slow pointer approach
        if(head == null || head.next == null){
            return head;
        }

        //Split the list into two halfes
        ListNode mid = getMid(head);
        ListNode left = sortList(head);     //sort the first half
        ListNode right = sortList(mid);     //sort the second half

        //Merge the sorted halfes
        return merge(left, right);
    }

    //Function to find middle value of the list
    private ListNode getMid(ListNode head){
        ListNode prev = null;

        while(head != null && head.next != null){
            prev = (prev == null) ? head : prev.next;
            head = head.next.next;
        }
        ListNode mid = prev.next;

        prev.next = null;       //Split the list into two halfes
        return mid;
    }

    //Function to merge two sorted lists
    private ListNode merge(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                tail.next = list1;
                list1 = list1.next;
            }else{
                tail.next = list2;
                list2 = list2.next;
            }

            tail = tail.next;
        }

        //Append the remaining nodes of list1 and list2
        tail.next = (list1 != null) ? list1 : list2;

        return dummy.next;
    }
}