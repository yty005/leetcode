import java.util.Arrays;

//最大数
public class leet179 {
    public static void main(String[] args){
        int[] nums = {3,30,34,5,9};
        largestNumber(nums);
    }
    /*
    制定排序规则
     */
    public static String largestNumber(int[] nums) {
        String[] numstr = new String[nums.length];
        for(int i=0;i< nums.length;i++){
            numstr[i] = Integer.toString(nums[i]);
        }
        sort(numstr);
        String str = "";
        for(int i=0;i<numstr.length;i++){
            str = str + numstr[i];
        }
        if(str.charAt(0)=='0'){
            return "0";
        }
        return str;
    }
    public static void sort(String[] nums){
        for(int i=0;i< nums.length;i++){
            for(int j=0;j< nums.length-1;j++){
                if((nums[j]+nums[j+1]).compareTo(nums[j+1]+nums[j])<0){
                    String tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
    }
}
