class Solution {
    public int characterReplacement(String s, int k) {
        //2 pointer  + Sliding window concept
        int [] occurance = new int[26];
        int left = 0, right = 0;
        int ans = 0;
        int maxOccur = 0;

        for(right = 0; right<s.length() ; right++){
            //take the maxOccurance from current maxOCcur and previous
            maxOccur = Math.max(maxOccur , ++occurance[s.charAt(right) - 'A']);

            if(right  - left + 1 - maxOccur > k){
                //decrement the value first
                occurance[s.charAt(left) - 'A']--;
                //than increment the position of left pointer
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}