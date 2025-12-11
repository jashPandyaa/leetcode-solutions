class Solution {
    public String minWindow(String s, String t) {
        //edge case
        if(s.length() == 0 || t.length() == 0 || s.length() < t.length()){
            return "";
        }

        Map<Character, Integer> mapT = new HashMap<>();

        //Put all characters of T string in a Hashmap mapT
        for(int i=0; i<t.length(); i++){
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i),0) + 1);
        } 
        
        int required = mapT.size();
        int l = 0, r = 0;
        int create = 0;
        //-1 keeps track of current substring , 0's are for left and right pointers
        int []ans = {-1, 0 , 0};
        
        Map<Character, Integer> subStringMap = new HashMap<>();

        //Run loop untill right pointer reaches the end of the string S
        while( r < s.length() ){
            //Add the entry of SubString to HashMap
            char c = s.charAt(r);
            int count = subStringMap.getOrDefault(c, 0);
            subStringMap.put(c, count+1);
            if(mapT.containsKey(c) && subStringMap.get(c).intValue() == mapT.get(c).intValue()){
                create++;
            } 
            while( l <= r && required == create){
                c = s.charAt(l);
                if( ans[0] == -1 || ans[0] >= r - l + 1){
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

            subStringMap.put(c, subStringMap.get(c) - 1);
                if(mapT.containsKey(c) && subStringMap.get(c).intValue() < mapT.get(c).intValue()){
                    create--;
                }
                l++;
            } 
            r++;
        }
        //incase we didn't get the valid subString of S in t such as example 3
            if(ans[0] == -1){
                return "";
            }

            return s.substring(ans[1], ans[2] + 1);
    }
}