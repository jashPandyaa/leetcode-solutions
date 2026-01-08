/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String reserialize(TreeNode root, String str){
        //If root is null add that as well which is what serialization
        if(root == null){
            str += "null,";
        }else{
            //PreOrder : Root -> Left -> Right
            str += String.valueOf(root.val) + ",";
            str = reserialize(root.left, str);
            str = reserialize(root.right, str);
        }

        return str;
    }
    public String serialize(TreeNode root) {
        return reserialize(root, "");
    }

    // Decodes your encoded data to tree.
    public TreeNode redeserialize(List<String> str){
        if(str.get(0).equals("null")){
            str.remove(0);
            return null;
        }

        //Get the current value than go for left and right subTree's values
        //get the root node and then remove it
        TreeNode root = new TreeNode(Integer.valueOf(str.get(0)));
        str.remove(0);

        root.left = redeserialize(str);
        root.right = redeserialize(str);

        return root;
    }

    public TreeNode deserialize(String data) {
        String []strArray = data.split(",");
        List<String> strList = new LinkedList<String>(Arrays.asList(strArray));
        return redeserialize(strList);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));