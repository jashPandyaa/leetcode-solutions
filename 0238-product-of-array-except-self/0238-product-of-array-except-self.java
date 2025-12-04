class Solution {
    public int[] productExceptSelf(int[] nums) {
        //create result array of size of nums
        int result[] = new int[nums.length];

        //Fill initial value of 1 in each cell of result array
        Arrays.fill(result, 1);

        //counter variables for pre and post 
        int pre = 1, post = 1;

        for(int i=0; i<nums.length; i++){
            //make result arrray with prefix value each element has in it's left (by default 1)
            result[i] = pre;
            //Update pre variable, by multiplying prev value of array & prefix value (e.g 1)
            pre = nums[i] * pre;
        }

        for(int i=nums.length-1; i>=0; i--){
            //Whatever value we had multiply by post fix variable
            result[i] = result[i]*post;
            //update post variable
            post = post*nums[i];
        }

        //we will have our product array except it self so return it
        return result;
    }
}