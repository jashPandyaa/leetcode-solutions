import java.util.*;

class Solution {
    int maxDiameter = 0; 
    public int diameterOfBinaryTree(TreeNode root){
        getHeight(root);
        return maxDiameter;
    }
    public int getHeight(TreeNode node) {
        if(node == null) return 0; 

        int leftHeight = getHeight(node.left); //height of left subtree
        int rightHeight = getHeight(node.right); //height of right subtree

        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}