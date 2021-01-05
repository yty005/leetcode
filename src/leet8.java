//字符串转换整数
//首先判断开头有没有空格，然后判断空格后的第一个元素，最后判断是否存在溢出
public class leet8 {
    public static void main(String []args){
        String s="-91283472332";
        int a = myAtoi(s);
        System.out.println(a);
    }
    public static int myAtoi(String str) {
        int len =0;
        int ans=0;
        int sign=1;
        while(len<str.length()&&str.charAt(len)==' '){
            len++;
        }
        if(len == str.length()){
            return 0;
        }
        if(str.charAt(len)=='-'){
            sign=-1;
            len++;
        }else if(str.charAt(len)=='+'){
            sign=1;
            len++;
        }else if(!Character.isDigit(str.charAt(len))){
            return 0;
        }

        while(len<str.length()&&Character.isDigit(str.charAt(len))){
            int d=str.charAt(len)-'0';
            if(ans>(Integer.MAX_VALUE-d)/10){
                if(sign==1){
                    return Integer.MAX_VALUE;
                }else{
                    return Integer.MIN_VALUE;
                }
            }
            ans=ans*10 + d;
            len++;
        }
        return ans*sign;
    }
}
