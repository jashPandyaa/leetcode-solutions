class Solution {
    public String longestCommonPrefix(String[] strs) {
        //Time complexity = O(s), sum of all strings inside array 'v' , S.C. = O(1)

        //edge case if it's empty already
        if( strs == null || strs.length == 0 ){
            return "";
        }

        //Start with the first string in the array as initial prefix
        String prefix = strs[0];

        //Compare the current prefix with each string in the array (flower in ex 1)
        for(int i=1 ; i<strs.length; i++){
            //Narrow down the prefix with each comparison 
            while( strs[i].indexOf(prefix) != 0 ){
                //shorten the prefix by one character from the end 
                prefix = prefix.substring(0, prefix.length() - 1);

                //if prefix becomes empty , there is no comman prefix
                if( prefix.isEmpty() ) return "";
            }
        }

        return prefix;
    }
}