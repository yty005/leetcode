import java.util.HashMap;

//有效的数独
public class leet36 {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer,Integer>[] rows = new HashMap[9];
        HashMap<Integer,Integer>[] col = new HashMap[9];
        HashMap<Integer,Integer>[] boxs = new HashMap[9];
        for(int i=0;i<9;i++){
            rows[i] = new HashMap<Integer, Integer>();
            col[i] = new HashMap<Integer, Integer>();
            boxs[i] = new HashMap<Integer, Integer>();
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    int n = (int)board[i][j];
                    int index = (i/3)*3+j/3;
                    rows[i].put(n,rows[i].getOrDefault(n,0)+1);
                    col[j].put(n,col[j].getOrDefault(n,0)+1);
                    boxs[index].put(n,boxs[index].getOrDefault(n,0)+1);

                    if(rows[i].get(n)>1||col[j].get(n)>1||boxs[index].get(n)>1){
                        return false;
                    }
                }




            }
        }

        return true;

    }
}
