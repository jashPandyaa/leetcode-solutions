import java.util.*;

class Solution {
    public boolean isSame(TreeNode s, TreeNode t){
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.val != t.val) return false;

        //Now check for left subtree of s and t & check for right subtree of s & t
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null){
            return false;
        }

        if(isSame(root, subRoot)){
            return true;
        }

        //Perform BFS on TreeNode root -> first perform for left side then right side
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}