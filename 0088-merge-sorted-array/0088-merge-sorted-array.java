class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //length of nums1
        int i = m - 1;
        //length of nums2
        int j = n - 1;
        //length of nums1 + nums2
        int k = m + n - 1;

        //starting condition , can be done other way around too
        while(j >= 0){
            //whichever element is greater push them in nums1 
            if( i >= 0 && nums1[i] > nums2[j] ){
                nums1[k--] = nums1[i--];
            }else{
                nums1[k--] = nums2[j--];
            }
        }
    }
}