import java.util.ArrayList;
import java.util.List;

//子集
//找到所有可能解，利用回溯
//设置子集长度
public class leet78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> list1 = new ArrayList<Integer>();
        for(int len =1;len<nums.length;len++){
            backtrack(len,nums,list,list1,-1);
        }

        return list;
    }
    public static void backtrack(int len,int[] num,List<List<Integer>> list,List<Integer> list1,int start){
        if(list1.size()==len){
            list.add(new ArrayList<>(list1));
            return;
        }
        for(int i=start+1;i<num.length;i++){
            list1.add(num[i]);
            backtrack(len,num,list,list1,i);
            list1.remove(list1.size()-1);
        }
    }


}
