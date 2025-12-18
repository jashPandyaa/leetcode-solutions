class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);

        Map.Entry<Integer, Integer> majorityEntry = null;
        for(Map.Entry<Integer, Integer> entry : counts.entrySet()){
            if(majorityEntry == null || entry.getValue() > majorityEntry.getValue()){
                majorityEntry = entry;
            }
        } 

        return majorityEntry.getKey();
    }

    private Map<Integer, Integer> countNums(int [] nums){
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();

        for(int num : nums){
            //If element is not already in H.M than add it in counts HashMap
            if(!counts.containsKey(num)){
                counts.put(num, 1);
            }else{
                //If already present than increase the number of frequencies of that element
                counts.put(num, counts.get(num) + 1);
            }
        }
        return counts;
    }
}