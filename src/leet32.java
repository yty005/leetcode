import java.util.Arrays;

public class leet32 {
    public int longestValidParentheses(String s) {
        int sum[] = new int[s.length()];
        int num[] = new int[s.length()];//记录有效的括号
        if(s.length()==0){
            return 0;
        }
        if(s.charAt(0)=='('){
            sum[0]=1;
        }else{
            sum[0]=0;
        }
        for(int i =1;i<s.length();i++){
            if(s.charAt(i)=='('){
                sum[i]=sum[i-1]+1;
            }else if(s.charAt(i)==')'&&sum[i-1]>0){
                sum[i] = sum[i-1]-1;
                num[i] = num[i]+1;
                //合并有效括号---内部num[i-1] 外部num[i-num[i*2]] 首先判断内部是否能进行合并，然后判断外部合并
                //加入i>1的判断，空间换时间，时间提升，空间消耗变大
                if(num[i]!=0&&num[i-1]!=0){//合并外部有效括号
                    num[i] = num[i]+num[i-1];
                }
                if(num[i]!=0&&i-num[i]*2>=0&&num[i-num[i]*2]!=0){//合并内部有效括号
                    num[i]=num[i]+num[i-num[i]*2];
                }
            }
        }
        //找到数组中最大元素
        int max = num[0];
        for(int i=1;i<num.length;i++){
            if(max<num[i]){
                max = num[i];
            }
        }

        return max*2;
    }
}



