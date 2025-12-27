class Solution {
    public int findDuplicate(int[] nums) {
        //Initialise fast and slow pointers in LL manner
        int slow = nums[0];
        int fast = nums[nums[0]];

        //Find the intersector of two pointers(i.e. where they meet)
        while( fast != slow){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        //Initilise slow to beginning of array 
        slow = 0;

        //Repeat the loop but this time fast and slow both 1 increment at a time
        while( fast != slow){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}