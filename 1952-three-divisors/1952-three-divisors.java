class Solution {
    public boolean isThree(int n) {
        int foundDivisor = 0;


        for(int i = 1; i <= n ; i++){   // 4
            if(n % i == 0){     // 4 % 4 == 0, 2++ , 3 
                foundDivisor++;     // 3
            }
        }

        if(foundDivisor == 3){
            return true;
        }
        return false;   
        
    }
}