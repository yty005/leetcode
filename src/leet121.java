//买卖股票的最佳时机
public class leet121 {
    public static void main(String[] args){
        int[] nums = {7,1,5,3,6,4};
        maxProfit1(nums);
    }
    /*
    找到最大利润，利用动态规划的方式计算dp[i][j]，表示第i个位置买入，第j个位置之前卖出，第i个位置比第j个位置的值小
     */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][prices.length];
        int max = 0;
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                if(prices[i]<prices[j]){
                    dp[i][j] = prices[j]-prices[i];
                }else{
                    dp[i][j] = 0;
                }
                if(max<dp[i][j]){
                    max = dp[i][j];
                }
            }
        }
        return max;
    }
    /*
    暴力
     */
    public static int maxProfit1(int[] prices) {
        int max = 0;
        for(int i=1;i<prices.length;i++){
            for(int j=0;j<i;j++){
                if(prices[j]<prices[i]){
                    max = Math.max(max,(prices[i]-prices[j]));
                }
            }
        }
        return max;
    }
    /*
    一次遍历
     */
    public static int maxProfit2(int[] prices) {
        int max_prices = 0;
        int min = prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]<min){
                min = prices[i];
            }else{
                if(max_prices<(prices[i]-min)){
                    max_prices = prices[i]-min;
                }
            }

        }
        return max_prices;
    }
}
