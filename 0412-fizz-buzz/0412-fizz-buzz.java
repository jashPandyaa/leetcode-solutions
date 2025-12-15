class Solution {
    public List<String> fizzBuzz(int n) {
         ArrayList<String> result = new ArrayList<>();

         for(int i = 1; i <= n; i++){
            if( i%3 == 0 && i%5 == 0){
                //if number is divisible by 5 and 3 both
                result.add("FizzBuzz");
            }else if( i%5 == 0){    
                //if number is divisible by 5 only
                result.add("Buzz");
            }else if( i%3 == 0){    
                //if number is divisible by 3 only
                result.add("Fizz");
            }else{
                //if number is not divisible by 5 or 3
                result.add(Integer.toString(i));
            }
         }

         return result;
    }
}