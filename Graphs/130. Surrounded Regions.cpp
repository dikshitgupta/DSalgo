class Solution {
public:
    void Surround(int x,int y,vector<vector<char>>& board){
        
        if(x>=board.size() || y>=board[0].size() || y<0 || x<0 || board[x][y]!='O') return;
        board[x][y]='1';
        Surround(x+1,y,board);
        Surround(x,y+1,board);
        Surround(x-1,y,board);
        Surround(x,y-1,board);
        return;
    }
    
    void solve(vector<vector<char>>& board) {
        
        // first column and last column
        
        for(int i=0;i<board.size();i++){
            Surround(i,0,board);
            Surround(i,board[0].size()-1,board);
        }
        
        // first and last row in the matrix
        for(int j=0;j<board[0].size();j++){
            Surround(0,j,board);
            Surround(board.size()-1,j,board);
        }
        
        
        for(int i=0;i<board.size();i++){
            for(int j=0;j<board[0].size();j++){
                if(board[i][j]=='O') board[i][j]='X';
                if(board[i][j]=='1') board[i][j]='O';
            }
        }
        
    }
};

/*
["O","X","X","O","X"]
["X","O","O","X","O"]
["X","O","X","O","X"]
["O","X","O","O","O"]
["X","X","O","X","O"]
*/


/*
["1","X","X","1","X"]
["X","O","O","X","1"]
["X","O","X","1","X"]
["O","X","1","1","1"]
["X","X","1","X","1"]
*/

// !=0 return
// 1 banado.
// call dfs



