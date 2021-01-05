//定义两个指针
public class leet44 {
    public boolean isMatch(String s, String p) {
        boolean flag = false;
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int i=1;i<=p.length();i++){
            if(p.charAt(i-1)=='*'){
                dp[0][i]=true;
            }else{
                break;
            }
        }
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=p.length();j++){
                if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }
                if(p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i-1][j]|dp[i][j-1];//有一个能匹配上，就为true，若均无法匹配，则为false
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
