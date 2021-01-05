import java.util.HashMap;

//每个数独只有唯一解，解数独
//回溯 按行填数
public class leet37 {
    public void solveSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][][] boxs = new boolean[3][3][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    int n = (int)board[i][j];
                    rows[i][n-1] = true;
                    cols[j][n-1] = true;
                    boxs[i/3][j/3][n-1] = true;
                }
            }
        }
        backtrack(0,0,board,rows,cols,boxs);
    }
    public static boolean backtrack(int row,int col,char[][] board,boolean[][] rows,boolean[][] cols,boolean[][][] boxs){
        if(col==9) {//当前行填满，转入下一行
            col = 0;
            row++;
            if(row == 9){
                return true;
            }
        }
        for(int num=0;num<9;num++){
            if(board[row][col]=='.'){
                boolean flag = (rows[row][num]||cols[col][num]||boxs[row/3][col/3][num]);//true表示该数字存在，不能填入，false相反
                if(!flag){
                    rows[row][num]=true;
                    cols[col][num]=true;
                    boxs[row][col][num]=true;
                    board[row][col]=(char) num;
                    if(backtrack(row,col+1,board,rows,cols,boxs)){
                        return true;
                    }
                    board[row][col]='.';
                    rows[row][num]=false;
                    cols[col][num]=false;
                    boxs[row][col][num]=false;
                }
            }
        }
        return false;
    }

}
