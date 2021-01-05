public class leet189 {
    /*
    三种方法解决
    使用空间复杂度为O(1)的算法
     */
    public void rotate(int[] nums, int k) {//1
        while(k>0){
            //每次移动一个位置
            int tmp = nums[nums.length-1];
            for(int i= nums.length-1;i>0;i--){
                nums[i] = nums[i-1];
            }
            nums[0]=tmp;
            k--;
        }
    }
    public void rotate2(int[] nums, int k) {//2

    }

}
