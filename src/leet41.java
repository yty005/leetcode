import java.util.HashMap;

public class leet41 {
    public static void main(String[] args){
        int[] nums= {1};
        firstMissingPositive(nums);
    }
    /*
    将数据存入hash表，然后hash表查找
     */
    public static int firstMissingPositive(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=1;i<=nums.length;i++){
            if(!map.containsKey(i)){
                return i;
            }
        }

        return nums.length+1;
    }
    /*
    将数组当成哈希表，建立nums[i]=i-1规则，再原数组上进行修改，时间复杂度O(n)，空间复杂度O(1)
     */
    public static int firstMissingPositive1(int[] nums){
        int i=0;
        while(i<nums.length){
            if(nums[i]!=i+1&&nums[i]<=nums.length&&nums[i]>0){
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }else{
                i++;
            }

        }

        return nums.length+1;
    }
}
