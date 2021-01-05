//若后一状态仅仅取决于上一个状态，就用贪婪算法；若后一状态取决于之前的多个状态，就用动态规划。

public class leet70 {
    //找出所有方法，回溯
    public static void main(String[] args){
        climbStairs1(3);
    }
    //回溯，超时
    public static int climbStairs(int n) {
        backtrack(0,n,0);
        return 0;
    }
    public static int backtrack(int num,int n,int sum){
        if(sum==n){
            num++;
            return num;
        }else if(sum>n){
            return num;
        }
        for(int i=0;i<2;i++){
            num = backtrack(num,n,sum+i+1);
        }
        return num;
    }
    //动态规划  ----没考虑到动态规划    ----动态规划是记录轨迹的回溯
    public static int climbStairs1(int n){
        if(n==0){
            return 1;
        }else if(n<=2){
            return n-1;
        }
        int[] dp = new int[n];
        dp[0]=1;
        dp[1]=2;
        for(int i=2;i<n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }
}
