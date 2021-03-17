public class JZ11 {
    //剑指 Offer 10- II. 青蛙跳台阶问题
    public int numWays(int n) {

        int[] dp = new int[n+1];
        dp[0] = 0;
        if(n==0){
            return 0;
        }
        dp[1] = 1;
        if(n==1){
            return 1;
        }
        dp[2] = 2;
        for(int i=2;i< dp.length;i++){
            dp[i] = (dp[i-1]+dp[i-2])%1000000007;
        }
        return dp[n];
    }
}
