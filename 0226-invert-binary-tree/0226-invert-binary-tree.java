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
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }

        //Take right & left subTree of root node untill both reaches null.
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);

        //swap right and left node's value 
        root.right = left;
        root.left = right;
        
        return root;
    }
}