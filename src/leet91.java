public class leet91 {
    public static void main(String[] args){
        numDecodings("26110559717");
    }
    //动态规划
    //设dp[i] 表示到第i个元素可能的解码数
    //dp[i] = dp[i-1]+1 + dp[i-2]+1
    public static int numDecodings(String s) {
        if(s.length()==0){
            return 0;
        }
        if(s.charAt(1)=='0'){
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for(int i=1;i<s.length();i++){
            int x = Integer.valueOf(s.charAt(i-1))-48;
            int y = Integer.valueOf(s.charAt(i))-48;
            if(x==0){
                dp[i]=dp[i-1];
            }else if(x==1){
                if(y!=0){
                    if(i==1){
                        dp[i] = dp[i-1]+1;
                    }else{
                        dp[i] = dp[i-1] +dp[i-2];
                    }
                }else{
                    if(i==1){
                        dp[i] = 1;
                    }else{
                        dp[i] = dp[i-2];
                    }

                }
            }else if(x==2){
                if(y<=6&&y>0){
                    if(i==1){
                        dp[i] = dp[i-1]+1;
                    }else{
                        dp[i] = dp[i-1] +dp[i-2];
                    }
                }else if(y==0){
                    if(i==1){
                        dp[i] = 1;
                    }else{
                        dp[i] = dp[i-2];
                    }
                }else{
                    dp[i] = dp[i-1];
                }
            }else if(x>2){
                if(y==0){
                    return 0;
                }
                dp[i] = dp[i-1];
            }
        }
        return dp[s.length()-1];
    }
}
