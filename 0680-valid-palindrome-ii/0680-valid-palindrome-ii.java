class Solution {
    public boolean validPalindrome(String s) {
        int lp = 0 , rp = s.length() - 1;

        while(lp < rp){
            if(s.charAt(lp) != s.charAt(rp)){
                return isPalindrome(s, lp + 1, rp) || isPalindrome(s, lp, rp - 1);
            }

            lp++;
            rp--;
        }

        return true;
    }

    //Helper method to check for palindrome.
    private boolean isPalindrome(String s, int lp, int rp){
        while(lp < rp){
            if(s.charAt(lp) != s.charAt(rp)){
                return false;
            }

            lp++;
            rp--;
        }

        return true;
    }
}