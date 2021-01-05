public class leet69 {
    //牛顿迭代法
    public static void main(String[] args){
        mySqrt(2147395599);
    }
    public static int mySqrt(int x) {
        double a = 10;
        for(int i=0;i<30;i++){
            if(a==(a + x/a)/2){
                break;
            }
            a = (a + x/a)/2;

        }

        return (int)a;
    }

}
