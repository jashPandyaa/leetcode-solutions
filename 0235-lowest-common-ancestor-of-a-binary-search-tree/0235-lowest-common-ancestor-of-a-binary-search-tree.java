class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int parentVal = root.val;
        int pVal = p.val;
        int qVal= q.val;

        //Check if p and q both are on the right side of BST or left side of BST
        if(pVal > parentVal && qVal > parentVal){
            return lowestCommonAncestor(root.right, p, q);
        }
        if(pVal < parentVal && qVal < parentVal){
            return lowestCommonAncestor(root.left, p, q);
        }     

        //if that's not the case , i.e root is either p or q it self
        return root;
    }
}