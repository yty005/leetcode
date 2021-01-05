//pow(x,n)
//计算x的n次幂
/*
快速幂算法
 */
public class leet50 {
    //O(n)
    public double myPow(double x, int n) {
        double sum = 1;
        if(n>0){
            for(int i=1;i<=n;i++){
                sum = sum*x;
            }
        }else if(n<0){
            for(int i=-1;i>=n;i--){
                sum = sum/x;
            }
        }else if(n==0){
            return 1;
        }
        return sum;
    }
    /*
    快速幂算法
    幂次能被2整除，说明x可以直接扩大2倍，n缩小2倍
    幂次不能被2整除，需要在sum中*x，然后变为上述情况
     */
    public double myPow1(double x,int n){
        if(x==0){
            return 0;
        }
        double tmp = x;
        double sum = 1.0;
        if(n>0){
            while(n>0){
                if(n%2!=0){
                    sum = sum*x;
                }
                x = x*x;
                n = n/2;
            }
        }else if(n<0){
            while(n<0){
                if(n%2!=0){
                    sum = sum/x;
                }
                x = x*x;
                n=n/2;
            }
        }else if(n==0){
            return 1;
        }
        return sum;
    }

}
