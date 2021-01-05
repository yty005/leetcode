import java.util.Arrays;

//下一个排列
public class leet31 {
    public void nextPermutation(int[] nums) {
        if(nums.length<2){
            return;
        }
        int flag =0;//标记符，表示数字进行过调整
        int sum[]=new int[nums.length-1];
        for(int i=0;i<nums.length-1;i++){//求两数之间距离
            sum[i]=nums[i]-nums[i+1];
        }
        //从最后两位开始，依次判断数字是否递增
        for(int i=nums.length-2;i>=0;i--){
            if(sum[i]<0){//出现递增，首先将该元素与和该元素最接近的元素（比该元素大）进行交换，然后对后面部分进行排序
                int min = sum[i];
                int j=0;
                for(j=i;j< sum.length-1;j++){
                    if(min+sum[i+1]<0&&Math.abs(min)>Math.abs(min+sum[i+1])){
                        min = min+sum[i+1];
                    }else{
                        break;
                    }
                }
                int temp=nums[i];
                nums[i]=nums[j+1];
                nums[j+1]=temp;
                Arrays.sort(nums,i+1,nums.length);
                flag = 1;
                break;
            }
        }

        if(flag==0){//表示数字未进行过调整，即前面的数字都比后面大，将nums数组进行翻转即可
            Arrays.sort(nums);
        }
    }
}
