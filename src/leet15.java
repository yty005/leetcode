import java.util.*;


//三数之和
//任取两个元素，计算sum，寻找数组中是否存在该元素的相反数，若存在，加入三元组
public class leet15 {
    public static void main(String []args){
        int nums[]={0,0,0,0};
        threeSum(nums);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<List<Integer>>();

        /*HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            map.put(i,nums[i]);
        }*/
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1;j<nums.length;j++){
                if((j>i+1)&&nums[j]==nums[j-1]){
                    continue;
                }
                sum=nums[i]+nums[j];
                int k=nums.length-1;
                while(k>j&&(-sum<nums[k])){//////
                    k--;
                }
                if(k==j){
                    break;
                }
                if(nums[k]==-sum){
                    list.add(Arrays.asList(nums[i],nums[j],-sum));
                }
                /*
                * while(k>j){
                    List<Integer> list1=new ArrayList<Integer>();
                    if(nums[k]==-sum&&k!=i&&k!=j){
                        list1.add(nums[i]);
                        list1.add(nums[j]);
                        list1.add(-sum);
                        list.add(list1);
                        break;
                    }
                    k--;
                }
                * */
            }
        }
        return list;
    }
}
