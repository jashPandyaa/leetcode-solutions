class Solution {
    public void sortColors(int[] nums) {
        //Dutch National Flag Approach -> Only applies on 3 distinct value (0, 1, 2)

        //Initialise 3 pointers
        int low = 0, high = nums.length - 1, curr = 0;

        while(curr <= high){
            //if the current element is 0(red), swap it with the element at 'low'
            //and move both current and low pointers one step forward
            if(nums[curr] == 0){
                    swap(nums, curr, low);
            low++;
            curr++;
            }else if(nums[curr] == 2){
                //if the current element is 2(blue), swap it with element at 'high'
                //Move high one step backwards.
                //Note: we don't move current forward here, bcoz the swapped element 
                //from high could be '0' and we need process it in the next iteration
                swap(nums, curr, high);
                high--;
            }else{
                //if current element is '1'(white), just move current forward
                curr++;
            }
        }
    }

    public void swap(int []nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}