class Solution {
    public int countSubstrings(String s) {
        int ans = 0;

        for(int i=0 ; i<s.length(); i++){
            //check for palidromic substring at ith position of loop
            ans +=  checkPalidrome(s, i, i);        //for odd ss 
            ans += checkPalidrome(s, i, i+1);       //for even ss
        }
        return ans;
    }

    public int checkPalidrome(String s, int left, int right){
        int count = 0;

        //Left and right charcters of substrings are same and not out of bound
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
            count++;
        }

        return count;
    }
}