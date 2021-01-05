//买卖股票的最佳时机
public class leet122 {
    public static void main(String[] args){
        int[] prices = {1,2,3,4,5};
        maxProfit(prices);
    }
    /*
    动态规划，设置dp[][] dp[1][i] = Math.max(dp[1][k]+dp[k][i],prices-min)
    内存溢出
     */
    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][prices.length];

        //先写部分，最后计算整个数\
        for(int j=1;j<prices.length;j++){
            for(int i=j-1;i>=0;i--){
                int min = prices[i];
                int max = 0;
                for(int k=i;k<j;k++){
                   if(max<dp[i][k]+dp[k+1][j]){
                       max = dp[i][k]+dp[k+1][j];
                   }
                   if(min > prices[k]){
                       min = prices[k];
                   }
                }
                dp[i][j] = Math.max(max,prices[j]-min);
            }
        }

        return dp[0][prices.length-1];
    }
    public static int maxProfit1(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i=1;i<prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        if(dp[prices.length-1][0]<0){
            return 0;
        }
        return dp[prices.length-1][0];
    }
    /*
    贪心算法   只要第二天大于第一天就卖出
     */
}
