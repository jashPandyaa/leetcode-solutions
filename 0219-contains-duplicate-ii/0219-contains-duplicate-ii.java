class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
       //Create a HashSet/Map to store Value
       HashSet<Integer> set = new HashSet<>();

        //Iterate through the array
       for(int i=0; i<nums.length; i++){
        //check ,if hashset contains the same element you are iterating
        if(set.contains(nums[i])) // yes, then duplicate found
            return true;
        set.add(nums[i]); //no , add it in the hashset

        //check if hashset's size is bigger than k element(e.g 4>3)
        if(set.size() > k){
            set.remove(nums[i-k]); //yes, then remove first element of Sliding window as well as from Set!
        }
       }

       //No duplicate from an array then return false!
       return false;
    }
}