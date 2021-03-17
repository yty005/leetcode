public class JZ10 {
    //剑指 Offer 10- I. 斐波那契数列
    public int fib(int n) {
        Long[] num = new Long[n];
        num[1] = 1L;
        num[0] = 1L;
        for(int i=2;i<n;i++){
            num[i] = num[i-1]+num[i-2];
            if(num[i]>1000000007){
                num[i] = num[i]-1000000007;
            }
        }
        return num[n-1].intValue();
    }
}
