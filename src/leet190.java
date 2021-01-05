public class leet190 {
    public int reverseBits(int n) {
        int sum = 0;
        for(int i=0;i<32;i++){
            sum = (sum<<1)+(n&1);
            n=n>>1;
        }
        return sum;
    }
}
