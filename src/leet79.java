//单词搜索
public class leet79 {
    //深度优先搜索
    //回溯 ----二维平面
    public static void main(String[] args){
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        exist(board,word);
    }
    public static boolean exist(char[][] board, String word) {
        //找到第一个字符
        boolean flag = false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    StringBuffer buffer = new StringBuffer();
                    flag = backtrack(buffer,word,i,j,board);
                }
                if(flag == true){
                    return flag;
                }
            }
        }


        return false;
    }
    public static boolean backtrack(StringBuffer buffer,String word,int i,int j,char[][] board){
        if(buffer.toString().equals(word)){
            return true;
        }
        //上下左右四个方向均可以移动
        //按照上下左右顺序进行移动，若碰触边界，则改变方向
        //上col--   下col++    左rows--   右rows++
        int col = i;
        int rows = j;
        buffer.append(board[col][rows]);
        if(col!=0){

            if(backtrack(buffer, word, col-1, rows, board)){
                return true;
            }
        }
        if(col!=board.length-1){
            if(backtrack(buffer, word, col+1, rows, board)){
                return true;
            }
        }
        if(rows!=0){
            if(backtrack(buffer, word, col, rows--, board)){
                return true;
            }
        }
        if(rows!=board[0].length){
            if(backtrack(buffer, word, col, rows++, board)){
                return true;
            }
        }
        return false;
    }
}
