import java.util.*;
class Solution {
    public boolean containsDuplicate(int[] nums){
        //Create HashSet which stores integers in it's set
        // note that it doesn't store key - value pair like HashMap. It stores only Key!!
        HashSet<Integer> set = new HashSet<>();

        //Iterate through array of nums
        for(int i=0; i<nums.length; i++){
            //If element is found in hashset(set) then return true i.e duplicate exists
            if(set.contains(nums[i])){
                return true;
            }else{  // if not add that current element in our hashset of set
                set.add(nums[i]);
            }
        }

        //If u did not found any duplicate element in array simply return false
        return false;
  }
}