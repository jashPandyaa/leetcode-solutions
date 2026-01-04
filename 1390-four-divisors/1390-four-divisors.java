class Solution {
    public int sumFourDivisors(int[] nums) {
        int totalSum = 0;

        for(int num : nums){
            int foundDivisor = 0;

            for(int divisor = 2 ; divisor*divisor <= num; divisor++){
                //check for remainder = 0 only othervise that can't be our divisor
                if(num % divisor == 0){
                    if(foundDivisor == 0){
                        foundDivisor = divisor; //fD = 3(divisor)
                    }else{
                        foundDivisor = 0;
                        break;

                    }
                }
            }
            // 3 > 0 && 3 != 21 / 3(which is 7)
            if(foundDivisor > 0 && foundDivisor != num / foundDivisor){ 
                //Found other divisor than found one(e.g for 21 = 3(foundDivisor) * 7(otherDivisor))
                int otherDivisor = num / foundDivisor; 
                totalSum += 1 + num + foundDivisor + otherDivisor;  // 1 , numItSelft(21) and the 2 we found
            }
        }

        return totalSum;
    }
}