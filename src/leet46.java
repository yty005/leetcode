import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//全排序
//回溯
public class leet46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        //StringBuffer buffer = new StringBuffer();
        List<Integer> list1 =new ArrayList<Integer>();

        backtrack(nums,list1,list);

        return list;
    }
    public static void backtrack(int[] nums,List<Integer> list1,List<List<Integer>> list){
        if(list1.size()== nums.length){//buffer转整数列表
            list.add(new ArrayList<>(list1));
        }
        for(int i=0;i< nums.length;i++){
            if(!list1.contains(nums[i])){
                list1.add(nums[i]);
                backtrack(nums,list1,list);
                list1.remove(list1.size()-1);
            }
        }
    }

}
