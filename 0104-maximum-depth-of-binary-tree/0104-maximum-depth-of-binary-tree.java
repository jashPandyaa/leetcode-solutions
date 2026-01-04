/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 import java.util.*;

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        //Call recursive function
        else{
            int leftMax = maxDepth(root.left);
            int rightMax = maxDepth(root.right);

            //Return the maximum one with one add bcoz root/node it self has 1 height/depth of it's own
            return Math.max(leftMax, rightMax) + 1;
        }
    }
}