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
class Solution {
    //Helper method for base case and edge cases at begginning
    public TreeNode flattenTree(TreeNode node){
        if( node == null ){
            return null;
        }

        if(node.left == null && node.right == null){
            return node;
        }

        //Find left most tail and right most tail
        TreeNode leftTail = flattenTree(node.left);
        TreeNode rightTail = flattenTree(node.right);

        //Main Logic
        if(leftTail != null){
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }

        //Whichever is null return opposite of that
        return rightTail == null ? leftTail : rightTail; 
    }

    public void flatten(TreeNode root) {
        flattenTree(root);

    }
}