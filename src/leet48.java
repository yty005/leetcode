//旋转图像
//先转置后镜像对称
public class leet48 {
    public void rotate(int[][] matrix) {
        //转置
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j< matrix.length;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        //镜像对称
        for(int i=0;i< matrix.length;i++){
            for(int j=0;j< matrix.length;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = matrix[i][j];
            }
        }
    }  
}
