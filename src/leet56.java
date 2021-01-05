import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//合并所有重叠区间
public class leet56 {
    public static void main(String[] args){
        int[][] num = {{1,4},{4,5}};
        merge(num);
    }
    public static int[][] merge(int[][] intervals) {
        //比较区间a末尾于区间b开端，若a末尾大于b开端，合并区间a和b
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for(int i=0;i<intervals.length;i++){
            List<Integer> list1 = new ArrayList<Integer>();
            list1.add(intervals[i][0]);
            list1.add(intervals[i][1]);
            list.add(list1);
        }

        //如果a1大于b0，则在列表中删除这两个元素，添加新元素a0，b1
        int i=0;
        int j=0;
        int len = 0;
        while(i< list.size()){
            j=i+1;
            len = list.size();
            while(j<list.size()){
                if((list.get(i).get(0)<=list.get(j).get(1)&&list.get(i).get(0)>=list.get(j).get(0))||
                        (list.get(j).get(0)<=list.get(i).get(1)&&list.get(j).get(0)>=list.get(i).get(0))){
                    int min = Math.min(list.get(i).get(0),list.get(j).get(0));
                    int max = Math.max(list.get(i).get(1),list.get(j).get(1));
                    list.remove(j);
                    list.remove(i);
                    list.add(i,Arrays.asList(min,max));
                    break;
                }else{
                    j++;
                }
            }
            if(len==list.size()){
                i++;
            }
        }
        int[][] num = new int[list.size()][2];
        for(int m=0;m< list.size();m++){
            num[m][0] = list.get(m).get(0);
            num[m][1] = list.get(m).get(1);
        }
        return num;
    }
}
