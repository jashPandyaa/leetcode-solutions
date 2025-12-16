class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            int odd = checkPalindrome(s, i, i);
            int even = checkPalindrome(s, i, i + 1);
            int maxLength = Math.max(odd, even);

            if (maxLength > right - left) {
                left = i - (maxLength - 1) / 2;  //to check for length of odd 
                right = i + maxLength / 2;      //to check for length of even
            }
        }

        return s.substring(left, right + 1);        
    }

    private int checkPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;    
    }    
}