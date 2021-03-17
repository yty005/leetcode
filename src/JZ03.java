import java.util.HashMap;

public class JZ03 {
    //剑指 Offer 03. 数组中重复的数字
    /*
    利用hashmap进行查找重复元素
     */
    public int findRepeatNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                return nums[i];
            }else{
                map.put(nums[i],1);
            }
        }
        return -1;
    }
}
