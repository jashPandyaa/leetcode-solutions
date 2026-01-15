class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        //initialize the parent array where parent[i] represents the parent of current node i
        int []parent = new int[edges.length + 1];
        for(int i = 1; i <= edges.length; i++){
            parent[i] = i; //initialy each node is its own parent
        } 

        //Iterate through the edges to find the redundant one
        for(int [] edge : edges){
            int node1 = edge[0];
            int node2 = edge[1];

            //find the roots of node1 and node2
            int root1 = find(parent, node1);
            int root2 = find(parent, node2);    

            //if the roots are the same, a cycle is detected, return the current edge.
            if(root1 == root2){
                return edge;
            }

            // Union the sets by making root1 parent of root2 and both merge
            parent[root2] = root1;
        }

        //if no cycle is found(which shouldn't happen in this problem) then return empty array
        return new int[0];
    }

    //Helper method to find the root of a particular node
    private static int find(int[] parent, int node){
        while(node != parent[node]){
            parent[node] = parent[parent[node]];    //Path compression for optimization
            node = parent[node];
        }
        return node;
    }
}