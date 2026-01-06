class Solution {
    //Using BFS we can easily solve this level vise problems
    public int maxLevelSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 1 , currLevel = 1;

        while(!queue.isEmpty()){
            int levelSize = queue.size() , levelSum = 0;

            //For each node at the current level:
            // Add its value to the level sum
            // Enqueue its children (if they exist) for processing in the next level
            for(int i = 0; i < levelSize ; i++){
                TreeNode node = queue.poll();
                levelSum += node.val;

                if(node.left != null) queue.add(node.left); 
                if(node.right != null) queue.add(node.right); 
            }

            if(levelSum > maxSum){
                maxSum = levelSum;
                maxLevel = currLevel;
            }

            currLevel++;
        }
        return maxLevel;
    }
}