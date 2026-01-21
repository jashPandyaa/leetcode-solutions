class Solution {
    public void reverseString(char[] s) {
        int lp = 0 , rp = s.length - 1;

        while(lp < rp){
            //Swap elements
            char temp = s[lp];
            s[lp] = s[rp];
            s[rp] = temp;

            //update the pointers , respectively.
            lp++;
            rp--;
        }
    }
}