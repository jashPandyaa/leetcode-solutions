import java.util.*;

class Solution {
    int preOrderIndex;
    Map<Integer, Integer> inOrderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrderIndex = 0;
        inOrderIndexMap = new HashMap<>();

        for(int i = 0; i < inorder.length; i++){
            inOrderIndexMap.put(inorder[i], i);
        }    

        return arrayToTree(preorder, 0 , preorder.length - 1);
    }

    public TreeNode arrayToTree(int []preorder, int left, int right){
        if(left > right){
            return null;
        }

        int rootValue = preorder[preOrderIndex];
        preOrderIndex++;

        TreeNode root = new TreeNode(rootValue);
        root.left = arrayToTree(preorder, left, inOrderIndexMap.get(rootValue) - 1);
        root.right = arrayToTree(preorder, inOrderIndexMap.get(rootValue)+ 1, right);

        return root;
    }
}