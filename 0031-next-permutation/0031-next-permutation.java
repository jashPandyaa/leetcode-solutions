class Solution {
    public void nextPermutation(int[] nums) {
        //traverse from reverse to check non descending element
        int i = nums.length - 2;

        //iterate untill we get the correct non descending element
        while( i >= 0 && nums[i+1] <= nums[i]){
            i--;
        }

        //check condition
        if( i >= 0){
            int j = nums.length - 1;
            //whether j is less or equal to i untill immidiate greater value of i
            while( nums[j] <= nums[i] ){
                j--;
            }
            //swap immidiate greater element j and i.
            swap(nums, i, j);
        }
        // i+1 bcoz we want to do revese from that position till the end of nums in array
        reverse(nums, i+1);
    }

    public void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void reverse(int []nums, int i){ // i is position from which we want to reverse the array
        int j = nums.length - 1;

        while(i < j){
            swap(nums, j, i);
            i++;
            j--;
        }
    }
}