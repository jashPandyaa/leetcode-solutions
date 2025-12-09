class Solution {
    public int firstMissingPositive(int[] nums) {
        //check whether 1 exists in array or not

        int contains = 0;
        int n = nums.length;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1){
                contains++;
                break;
            }
        }

        if(contains == 0){
            return 1;
        }

        //any single value which is not going to be in our n+1 range, will make it 1
        for(int i=0; i<nums.length; i++){
            if(nums[i] <= 0 || nums[i] > n){
                nums[i] = 1;
            }
        }

        //now iterate through an array , idetify each time when value is different than 1 go to that value's
        //index and change it's subsequent value with the negative value. Repeat this for the entire array 
        for(int i=0; i<nums.length; i++){
            int a = Math.abs(nums[i]);

            if( a == n){
                nums[0] = -Math.abs(nums[0]);
            }else{
                nums[a] = -Math.abs(nums[a]);
            }
        }

        //iterate loop from 1 to n+1 , return the index value which is postive 
        for(int i=1; i<n; i++){
            if(nums[i] > 0){
                return i; //our answer! F.M.P
            }
        }

        //edge cases, somehow we have found perfect sequence of integers in an array than return the n+1 bcoz it will be F.M.P
        if(nums[0] > 0){
            return n;
        }

        return n+1;
    }
}