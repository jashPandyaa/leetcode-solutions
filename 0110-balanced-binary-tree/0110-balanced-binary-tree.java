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
    //True if: Max difference of height of leftSubtree & rightSubTree can't exceed than 1
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        int absDiff = Math.abs(leftHeight - rightHeight);

        // if(absDiff > 1)
        return (absDiff <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }

    public int getHeight(TreeNode node){
        if(node == null){
            return 0;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}