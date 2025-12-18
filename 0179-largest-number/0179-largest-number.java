class Solution {
    public String largestNumber(int[] nums) {
        //We have to sort the nums using M.S.B beats first like descending sort via M.S.B

        //Convert int array to String array, so we can sort Later
        String []asStrs = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        //Sort String accordingly Custom Camparotor
        Arrays.sort(asStrs, new Comparator<String>(){
            public int compare(String a, String b){
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1);
            }
        });

        //edge cases
        if(asStrs[0].equals("0")){
            return "0";
        }

        //Build Largest number from sorted array
        StringBuilder largestNumberStr = new StringBuilder();

        for(String numAsStr : asStrs){
            largestNumberStr.append(numAsStr);
        }

        return largestNumberStr.toString();
    }
}