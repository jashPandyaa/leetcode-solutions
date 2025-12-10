class Solution {
    public int lengthOfLongestSubstring(String s) {
        //2 edge cases to work faster
        if( s == null || s.length() == 0){
            return 0;
        }

        if(s.length() == 1){
            return 1;
        }

        //initialize 2 pointers
        int left = 0, right = 0;
        int ans = 0;

        HashSet<Character> set = new HashSet<>();

        while(right < s.length()){
            char c = s.charAt(right);
            //if set already contains the element, remove left Pointer element from Set and increment it
            while(set.contains(c)){
                set.remove(s.charAt(left));
                left++;
            }
            //initially add the first element to the HashSet wherever right pointer is !
            set.add(c);
            //Take maximum of previous ans value of substring and current substring which we calculating rn.
            ans = Math.max(ans , right - left + 1);
            right++;
        }

        return ans;
    }
}