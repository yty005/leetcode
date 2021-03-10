public class leet152 {
    /*
    1.暴力
    2.回溯 ---计算所有的数，找出最大值
     */
    /*
    子数组中不包含
    0
    奇数个负数
     */
    public static int maxProduct(int[] nums) {
        int max = 0;
        int tmp = 1;//存储上一次的结果

        for(int i=0;i< nums.length;i++){
            for(int j=i;j< nums.length;j++){
                if(i==j){
                    tmp = nums[i];
                }else{
                    tmp = tmp*nums[j];
                }

                if(max<tmp){
                    max = tmp;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        maxProduct(nums);
    }

}
