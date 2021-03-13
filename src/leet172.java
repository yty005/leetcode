public class leet172 {
    //找出5的个数，每个5个数，出现包含一个5的数，每个25出现包含两个5的数，每隔125出现包含3个5的数
    public int trailingZeroes(int n) {
        int sum = 0;
        while(n>0){
            sum = sum + n/5;
            n = n/5;
        }
        return sum;
    }
}
