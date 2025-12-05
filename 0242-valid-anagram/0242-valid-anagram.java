class Solution {
    public boolean isAnagram(String s, String t) {
      //Check the length of both string , if they are not equal than return false
      if(s.length() != t.length()){
        return false;
      }

      //create an array count character frequencies 
      int []charCounts = new int[26]; //Assuming only lower case english characters

      //Increment count for each character in 's' and decrement for each in 't'
      for(int i=0; i<s.length() ; i++){
        charCounts[s.charAt(i) - 'a']++;
        charCounts[t.charAt(i) - 'a']--;
      }

      //Check if all counts are zero  
      for(int count : charCounts){
        if(count != 0)
            return false;
      }
      //If all counts are zero , then 't' is anagram of 's'
      return true;
    }
}