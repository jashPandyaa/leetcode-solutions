class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        // String sR = "";

        // for(int i=s.length()-1; i>=0; i--){
        //     sR += s.charAt(i);
        // }

        // if(!sR.equals(s)){  //compares actual content for strings
        //      return false;
        // }

        // return true;

        int l = 0, r = s.length() - 1;

        while( l <= r ){
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }else{
                return false;
            }
        }

        return true;
    }
}
//        replaceAll() → Replaces all matching characters.
//
//        "[^a-z0-9]" → The magic pattern inside:
//
//        [ ] → Match any character inside these brackets.
//
//        ^ → Inside [ ], it means "NOT" (so [^abc] means "not a, b, or c").
//
//        a-z → All lowercase letters (since we already converted to lowercase).
//
//        0-9 → All digits.
//
//        So [^a-z0-9] → "Match any character that is NOT a letter or number."
//
//        "" → Replace those unwanted characters with nothing (delete them).