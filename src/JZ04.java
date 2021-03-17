public class JZ04 {
    //剑指 Offer 04. 二维数组中的查找
    /*
    比较每一行的中间元素
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {

        return binaryTree(matrix,target,0, matrix[0].length-1);
    }
    public static boolean binaryTree(int[][] matrix,int target,int i,int j){
        if(i> matrix.length-1||j<0){
            return false;
        }
        if(matrix[i][j]==target){
            return true;
        }else if(matrix[i][j]<target){
            if(binaryTree(matrix,target,i+1,j)) return true;
        }else{
            if(binaryTree(matrix,target,i,j-1)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] num = {{1,   4,  7, 11, 15},{ 2,   5,  8, 12, 19}};
        findNumberIn2DArray(num,5);
    }

}
