import java.util.*;

class Solution {
    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, Integer.MIN_VALUE);
    }

    private int countGoodNodes(TreeNode node , int maxSoFar){
        if(node == null){
            return 0;
        }

        int count = 0;
        //Check if the current node is good node or not(first for root then l.s.t & r.s.t's particular node)
        if( node.val >= maxSoFar){
            count = 1;  //current node is a good node
            maxSoFar = node.val;    //update the max value along the path 
        } 

        //Count good nodes in left and right subTree
        count += countGoodNodes(node.left, maxSoFar);
        count += countGoodNodes(node.right, maxSoFar);

        return count;
    }
}