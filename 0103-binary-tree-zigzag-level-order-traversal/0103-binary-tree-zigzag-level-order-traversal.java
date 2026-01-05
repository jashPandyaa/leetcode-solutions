import java.util.*;

class Solution {
    //For one level(e.g 1) we go right to left & for another(e.g 2) we go left to right
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> results = new ArrayList<List<Integer>>();

        //add the root element with a delimiter to kickoff the BFS Loop
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addLast(root);
        queue.addLast(null);

        LinkedList<Integer> levelList = new LinkedList<Integer>();
        boolean isOrderLeft = true;

        while(queue.size() > 0){
            TreeNode currNode = queue.pollFirst();

            if(currNode != null){
                //left to right
                if(isOrderLeft == true){
                    levelList.addLast(currNode.val);
                }else{ //right to left
                    levelList.addFirst(currNode.val);
                }
                //add both children  
                if(currNode.left != null){
                    queue.addLast(currNode.left);
                }
                if(currNode.right != null){
                    queue.addLast(currNode.right);
                }
            }else{
                //we finish the scan of one level
                results.add(levelList);
                levelList = new LinkedList<Integer>();

                //Prepare for the next level
                if(queue.size() > 0){
                    queue.addLast(null);
                }
                isOrderLeft = !isOrderLeft;
            }
        }
        return results;
    }
}