class Solution {
    public int[] twoSum(int[] nums, int target) {
        //Create a hashmap to store numbers and their indicies respectively
        HashMap<Integer, Integer> map = new HashMap<>();

        //Iterate in given array
        for(int i=0; i<nums.length; i++){
            //Calculate the complement of the given number
            int complement = target - nums[i];

            //Check if complement is already in hashmap or not?
            if( map.containsKey(complement) ){
                //if found, return the indices of the complement and current number
                return new int[]{map.get(complement), i};
            }

            //Otherwise, add the current number and it's indices in the hashmap
            map.put(nums[i],i);
        }

        //Return the empty array if no solution is found, in our case this won't come true (problem constrains)
        return new int[]{};
    }
}
