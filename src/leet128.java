import java.util.HashMap;

public class leet128 {
    public static void main(String[] args){
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        longestConsecutive(nums);
    }
    /*
    对每一个元素，判断连续的最长序列
     */
    public static int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i< nums.length;i++){
            map.put(nums[i],1);
        }
        int longest = 1;
        int current = 1;
        for(int i=0;i< nums.length;i++){
            current = 1;
            if(!map.containsKey(nums[i]-1)){
                int k=nums[i]+1;
                while(map.containsKey(k)){
                    current++;
                    if(current>longest){
                        longest = current;
                    }
                    k++;
                }

            }
        }
        return longest;
    }
}
