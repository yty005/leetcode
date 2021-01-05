public class leet130 {
    /*
    在边界上的o不能被包围，与边界o相连的o不能被包围，找到被包围的o，将其修改为x
     */
    public void solve(char[][] board) {
        for(int i=0;i<=board.length-1;i++){
            for(int j=0;j<=board[0].length-1;j++){
                //按照边界，找到所有与边界连通的o
                if(board[i][j]=='O'||i==0||j==0||i== board.length-1||j==board[0].length-1){
                    dfs(board,i,j);
                }
            }
        }
        for(int i=0;i<= board.length-1;i++){
            for(int j=0;j<= board[0].length-1;j++){
                if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }
                if(board[i][j]=='-'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    //深度优先搜索
    public static void dfs(char[][] board,int i,int j){
        if(i<0||i> board.length-1||j<0||j>board[0].length-1||board[i][j]!='O'){
            return;
        }
        board[i][j] = '-';
        dfs(board,i-1,j);
        dfs(board,i+1,j);
        dfs(board,i,j-1);
        dfs(board,i,j+1);
    }
}
