import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//矩阵置零
public class leet73 {
    public static void main(String[] args){
        int[][] a = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes2(a);
    }

    //O(mn)的额外空间
    public void setZeroes(int[][] matrix) {
        //将数组中的0元素存入列表
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for(int i=0;i< matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    list.add(Arrays.asList(i,j));
                }
            }
        }
        //从列表中寻找0元素位置，然后将数组中该行该列元素修改为0
        for(int i=0;i< list.size();i++){
            for(int k = 0;k< matrix.length;k++){//将该行全改为0
                matrix[k][list.get(i).get(1)] = 0;
            }
            for(int m=0;m<matrix[0].length;m++){//将该列全改为0
                matrix[list.get(i).get(0)][m] = 0;
            }
        }
    }
    //O(m+n)的额外空间
    public void setZeroes1(int[][] matrix) {
        //定义两个列表col rows 分别存储0的行信息和列信息，遇到重复则不存储
        List<Integer> rows = new ArrayList<Integer>();//行
        List<Integer> col = new ArrayList<Integer>();//列
        for(int i=0;i< matrix.length;i++){
            for(int j=0;j< matrix[0].length;j++){
                if(matrix[i][j]==0){
                    if(!rows.contains(i)){
                        rows.add(i);
                    }
                    if(!col.contains(j)){
                        col.add(j);
                    }
                }
            }
        }
        for(int i=0;i< rows.size();i++){
            for(int k=0;k< matrix[0].length;k++){
                matrix[rows.get(i)][k] = 0;
            }
        }
        for(int j=0;j< col.size();j++){
            for(int k=0;k< matrix.length;k++){
                matrix[k][col.get(j)] = 0;
            }
        }
    }
    public static void setZeroes2(int[][] matrix){
        //利用第一行和第一列来标记数组中哪行存在0元素，若m[i][j]为0，则将m[i][0]=0,m[0][j]=0，
        // 设立两个标记位用来表示原始数组中第一行第一列中是否包含0元素
        boolean rows0 = false;
        boolean col0 = false;
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]==0){
                col0 = true;
                break;
            }
        }
        for(int i=0;i< matrix[0].length;i++){
            if(matrix[0][i]==0){
                rows0 = true;
                break;
            }
        }
        for(int i=1;i< matrix.length;i++){
            for(int j=1;j< matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=1;i<matrix.length;i++){
            if(matrix[i][0]==0){
                for(int j=1;j< matrix[0].length;j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j=1;j<matrix[0].length;j++){
            if(matrix[0][j]==0){
                for(int i=1;i< matrix.length;i++){
                    matrix[i][j] = 0;
                }
            }
        }
        if(rows0){
            for(int i=0;i< matrix[0].length;i++){
                matrix[0][i]=0;
            }

        }
        if(col0){
            for(int i=0;i< matrix.length;i++){
                matrix[i][0]=0;
            }

        }
    }
}
