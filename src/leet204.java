import java.util.Arrays;

public class leet204 {
    //统计所有小于非负整数 n 的质数的数量
    //1.时间复杂度On2
    public int countPrimes(int n) {
        if(n==0){
            return 0;
        }
        int count = 0;
        for(int i=1;i<n;i++){
            if(panduan(i)){
                count++;
            }
        }

        return count;
    }
    public boolean panduan(int num){
        //判断该数是否为质数
        if(num==1){
            return false;
        }
        for(int i=2;i*i<num;i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
    //2.埃及筛
    public int countPrimes1(int n) {
        if(n==0||n==1){
            return 0;
        }
        int count = 0;
        int[] num = new int[n];
        Arrays.fill(num,1);
        for(int i=2;i<n;i++){
            if(num[i]==1){
                count++;
                for(int j=i*2;j<n;j=j+i){
                    num[j] = 0;
                }
            }
        }
        return count;
    }
}
