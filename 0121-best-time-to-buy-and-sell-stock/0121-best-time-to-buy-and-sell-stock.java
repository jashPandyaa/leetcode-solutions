class Solution {
    public int maxProfit(int[] prices) {
       int maxProfit = 0;
       int minBuyDate = Integer.MAX_VALUE;

       for(int i=0; i<prices.length; i++){
        if( prices[i] < minBuyDate ){   
             minBuyDate = prices[i];
        }else{
            int profit = prices[i] - minBuyDate; 
            maxProfit = Math.max(maxProfit , profit);
        }
       }

       return maxProfit;
    }
}