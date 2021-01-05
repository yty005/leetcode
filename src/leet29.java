public class leet29 {
    public static void main(String[] args){
        int a =-2147483648;
        int b =-1;
        divide(a,b);
    }
    public static int divide(int dividend, int divisor) {//转换为正数，逐次减除数，超时
        int flag1=0;
        if(dividend>0){
            flag1= 1;
        }else if(dividend<0){
            flag1=-1;
        }
        int flag2=0;
        if(divisor>0){
            flag2= 1;
        }else if(divisor<0){
            flag2=-1;
        }
        Long i=Math.abs((long)dividend);
        Long j=Math.abs((long)divisor);
        long sum=0;
        while(i>0){
            if(sum == 2147483647){
                break;
            }
            if(i>=j){
                i=i-j;
                sum++;
            }else{
                break;
            }
        }


        return (int)(sum*flag1*flag2);
    }
    public static int divide1(int dividend, int divisor) {//同减异加
        if(dividend==0){
            return 0;
        }
        int flag = 1;
        if((dividend>0&&divisor<0)||(dividend<0&&divisor>0)){
            flag = -1;
        }
        Long i = (long)dividend;
        int sum = 0;
        while(true){
            if(flag==1){
                i = i - divisor;
                sum++;
            }else{
                i = i + divisor;
                sum++;
            }

        }
    }
}
