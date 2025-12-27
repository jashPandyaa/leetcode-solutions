/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    //To copy tracks of random and next nodes in LL
    HashMap<Node, Node> visitedNode = new HashMap<>();
    //it will recursive method
    public Node copyRandomList(Node head) {
        //Terminating edge case
        if(head == null){
            return null;
        }      
        
        if(this.visitedNode.containsKey(head)){
            return this.visitedNode.get(head);
        }

        Node node = new Node(head.val, null, null);

        //Keep track of visited nodes
        this.visitedNode.put(head, node);
        //Iterate through next Node via next 
        node.next = copyRandomList(head.next);
        //Iterate through random Node via random 
        node.random = copyRandomList(head.random);

        return node;
    }
}