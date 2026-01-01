class Solution {
    //Suppose we have : // digits == [9, 9]; ans = [1, 0 , 0]
    //if case won't be executed , direct digits[i] = 0
    //meaning [9 , 9] will be [0, 0]
    //now digits length will be increased from 2 to 3 
    //i.e digits = [0, 0 ,0]  : 0 will be by default value for new increased size digits
    //At last store do, digits[0] == 1, bcoz that is our answer : [1, 0 , 0];
    public int[] plusOne(int[] digits) { 
        for (int i = digits.length - 1; i >= 0; i--) {
            //This is only for case 1 & 2
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
             //for case 3: n = 1, digits[i] == 9 will become digits[i] == 0
            digits[i] = 0; 
        }

        digits = new int[digits.length + 1]; //for case 3: n = 1, n + 1 = 2 size now rn.
        digits[0] = 1;
        return digits;
    }
}