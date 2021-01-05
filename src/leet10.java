//正则表达式匹配
public class leet10 {
    public static void main(String[] args){
        String s = "aab";
        String p = "c*a*b";
        isMatch(s,p);
    }
    public static boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        for(int i=0;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(p.charAt(j-1)!='*'){
                    if(s.charAt(i)==p.charAt(j-1)||p.charAt(j-1)=='.'){
                        if(i!=0){
                            dp[i][j]=dp[i-1][j-1];
                        }
                    }
                }else{//=*
                    if(s.charAt(i)==p.charAt(j-1)||p.charAt(j-1)=='.'){
                        if(i!=0){
                            dp[i][j]=dp[i][j-2]|dp[i-1][j];
                        }
                    }else{
                        if(j>2){
                            dp[i][j]= dp[i][j-2];
                        }
                    }
                }
            }
        }
        return dp[n][m];
    }
}
