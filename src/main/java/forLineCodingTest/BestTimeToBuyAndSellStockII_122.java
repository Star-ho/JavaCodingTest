package forLineCodingTest;

public class BestTimeToBuyAndSellStockII_122 {
    public static void main(String[] arg){
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }
    public static int maxProfit(int[] prices) {
        int max=0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i]<prices[i+1]){
                max+=prices[i+1]-prices[i];
            }
        }
        return max;
    }
}
