package miscellaneous_practice;

import java.util.List;

/**
 * NQueens
 */
public class NQueens {
    // T(n)= N!*N // for every column, check every next col in recursionso N!
    // S(c) = N^@
    private static boolean isPossible(int col, int row,char[][] board){
            int dupRow=row;
            int dupCol=col;

            while(col>=0){
                if(board[row][col]=='Q'){
                    return false;
                }
                col--;
            }

            col=dupCol;
            // since we r going col wise we will not have any elements a head of current col
            // also or every column col, there is only one Q at a time, so no need tocheck vertically
            while(row>=0&& col>=0){
                if(board[row][col]=='Q'){
                    return false;
                }
                col--;
                row--;
            }

                col=dupCol;
                row=dupRow;
            while(row<board.length && col>=0){
                if(board[row][col]=='Q'){
                    return false;
                }
                col--;
                row++;
            }

            return true;
    }

    public static void solveQuuens(char board[][], int col) {

        //check col wise possibility of q and every row. Also remember to remove Q while backtracking
        if(col==board.length){
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board.length;j++){
                        System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for(int row=0;row<board.length;row++){
            if(isPossible(col, row, board)){
                board[row][col]='Q';
                solveQuuens(board, col+1);
                board[row][col]='.';
            }
        }
        
    }

    public static void solveBoard(int N){
        char[][] board=new char[N][N];
             for(int i=0;i<board.length;i++){
                for(int j=0;j<board.length;j++){
                        board[i][j]='.';
                }
            }

        solveQuuens(board,0);
    }
    public static void main(String[] args) {
         int N = 4;
        solveBoard(N);
    }
}