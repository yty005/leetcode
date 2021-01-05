public class leet474 {
    public static void main(String[] args){
        String[] strs = {"10", "01", "101", "0"};
        int m=3;
        int n=2;
        findMaxForm(strs,m,n);
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];//i个0，j个1
        for(int k=0;k<strs.length;k++){
            int count = zero(strs[k]);
            for(int i=m;i>=count;i++){
                for(int j=n;j>=(strs[k].length()-count);j++){
                    dp[i][j]=Math.max(dp[i-count][j-(strs[k].length()-count)]+1,dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }
    public static int zero(String s){
        int tmp=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                tmp++;
            }
        }
        return tmp;
    }

}
