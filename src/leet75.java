public class leet75 {
    public static void main(String[] args){
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
    }

    public static void sortColors(int[] nums) {
        //利用快排，将支点设立为1
        quicksort(nums,0, nums.length-1);
    }
    public static void quicksort(int[] nums,int left,int right){
        if(left>=right){
            return;
        }
        boolean flag = false;//false j--  true i++
        int i=left;
        int j=right;
        while(i<j){
            if(nums[i]>=nums[j]){
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                flag = !flag;
            }
            if(flag){
                i++;
            }else{
                j--;
            }
        }
        quicksort(nums,left,i-1);
        quicksort(nums,i+1,right);
    }
    /*
    设置两个指针，zero和two，0到zero表示0元素，two到len-1为2，当当前元素为0时，交换当前元素和zero指针所指元素，
    当当前元素为1时，i++，
    当前元素为2时，交换当前元素和two所指元素
    以上，遍历以此数组即可
     */
}
