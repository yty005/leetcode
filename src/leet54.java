import com.sun.scenario.animation.shared.SingleLoopClipEnvelope;

import java.util.ArrayList;
import java.util.List;

//旋转矩阵
/*

 */
public class leet54 {
    public static void main(String[] args){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        spiralOrder(matrix);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {//行动路线   左下右上   碰壁规则   下左上右
        List<Integer> list = new ArrayList<Integer>();
        int m = matrix.length;
        int n = matrix[0].length;
        int[] flag = {matrix.length-1,matrix[0].length-1,0,1};
        int len=0;
        int i=0;
        int j=0;
        while(len <m*n){
            list.add(matrix[i][j]);
            len++;
            if(i==flag[3]-1&&j<=flag[0]){
                if(j<flag[0]){
                    j++;
                }else{
                    i++;
                }
            }else if(j==flag[0]&&i<=flag[1]){
                if(i<flag[1]){
                    i++;
                }else{
                    j--;
                }
            }else if(i==flag[1]&&j>=flag[2]){
                if(j>flag[2]){
                    j--;
                }else{
                    i--;
                }
            }else if(j==flag[2]&&i>=flag[3]){
                if(i>flag[3]){
                    i--;
                }else{
                    j++;
                    flag[0] = flag[0]-1;
                    flag[1] = flag[1]-1;
                    flag[2] = flag[2]+1;
                    flag[3] = flag[3]+1;
                }
            }
        }
        return list;
    }
}
