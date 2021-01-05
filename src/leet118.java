import java.util.ArrayList;
import java.util.List;

//杨辉三角
public class leet118 {
    public static void main(String[] args){
        generate(5);
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> list1 = new ArrayList<Integer>();
        int[][] num = new int[numRows][numRows];
        num[0][0] = 1;
        list1.add(num[0][0]);
        list.add(new ArrayList<>(list1));
        list1.clear();
        for(int i=1;i<numRows;i++){
            for(int j=0;j<=i;j++){
                if(j==0||j==i){
                    num[i][j] = 1;
                }else{
                    num[i][j] = num[i-1][j] + num[i-1][j-1];
                }
                list1.add(num[i][j]);
            }
            list.add(new ArrayList<>(list1));
            list1.clear();
        }
        return list;
    }
}
