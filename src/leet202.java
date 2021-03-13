public class leet202 {
    //1.利用快慢指针，不存在循环则是快乐数
    //2.循环n次后不符合条件则不为快乐数
    public boolean isHappy(int n) {
        int count = 0;//记录循环次数
        while(count<10000){
            int sum = 0;
            while(n>0){
                sum = sum +(int)Math.pow(n%10,2.0);
                n = n/10;
            }
            if(sum == 1){
                return true;
            }else{
                n = sum;
            }

            count++;
        }
        return false;
    }
}
