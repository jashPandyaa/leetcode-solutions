class Solution {
    public void solve(char[][] board) {
        if(board.length == 0 || board == null) return;

        int m = board.length , n = board[0].length;

        //Mark boundary-connected '0's with 'T'
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //For edged, 'O' nodes only
                if((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O'){
                    dfs(board, i , j);
                }
            }
        }

        //Capture surrounded region and revert  'T' to 'O'
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == 'T'){   //T is for visited nodes only
                    board[i][j] = 'O';
                }
            }
        }   
    }

    public void dfs(char board[][], int i, int j){
        if(i < 0 || j < 0 || i >= board.length || j >= board[i].length || board[i][j] != 'O'){
            return;
        }

        board[i][j] = 'T'; //Mark as visited
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
    }
}