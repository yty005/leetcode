import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//组合总和
//找出所有解，回溯
public class leet39 {
    public static void main(String[] args){
        int[] candidates = {2,3,6,7};
        int target = 7;
        combinationSum(candidates,target);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> list1 = new ArrayList<Integer>();
        Arrays.sort(candidates);
        backtrack(0,candidates,target,0,list1,list);
        return list;
    }
    public static void backtrack(int start,int[] candidates,int target,int sum,List<Integer> list1,List<List<Integer>> list){
        if(sum>target){
            return;
        }else if(sum==target){
            list.add(new ArrayList<>(list1));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            list1.add(candidates[i]);

            sum = sum + candidates[i];
            backtrack(i,candidates,target,sum,list1,list);
            sum = sum - candidates[i];

            list1.remove(list1.size()-1);
        }

    }

}
