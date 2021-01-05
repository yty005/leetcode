import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leet40 {
    public static void main(String[] args){
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        combinationSum2(candidates,target);
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> list1 = new ArrayList<Integer>();
        Arrays.sort(candidates);
        backtrack(0,0,list,list1,target,candidates);
        return list;
    }
    public static void backtrack(int start,int sum,List<List<Integer>> list,List<Integer> list1,int target,int[] candidates){
        if(sum == target){
            if(!list.contains(list1)){
                list.add(new ArrayList<Integer>(list1));
            }
            return;
        }else if(sum>target){
            return;
        }
        for(int i = start;i<candidates.length;i++){
            list1.add(candidates[i]);
            sum = sum + candidates[i];
            backtrack(i+1,sum,list,list1,target,candidates);
            sum = sum - candidates[i];
            list1.remove(list1.size()-1);
        }
    }
}
