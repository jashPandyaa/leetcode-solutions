import java.util.*;
class Solution {
    public ArrayList<Integer> inOrder(TreeNode root, ArrayList<Integer> arr){
        if(root == null){
            return arr;
        }
        //left -> Root -> Right
        inOrder(root.left, arr);
        arr.add(root.val);
        inOrder(root.right, arr);

        return arr;
    }

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = inOrder(root, new ArrayList<>());

        //Return k - 1 beacuse arraylist is 0 indexed and BST is 1 index(given in ques)
        return nums.get(k - 1);  
    }
}