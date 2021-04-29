#include <bits/stdc++.h>
using namespace std;

// 174 dungeon game leetcode
class Solution {
public:
    int calculateMinimumHP(vector<vector<int>>& dungeon) {
    int m=dungeon.size();
    int n=dungeon[0].size();
        
    vector<vector<int>> dp(m,vector <int> (n,0));
    
    
    for(int i=m-1;i>=0;i--){
        for(int j=n-1;j>=0;j--){
            if(i==m-1 && j==n-1) dp[i][j]= dungeon[i][j]>0 ? 1 : abs(dungeon[i][j]) + 1 ;
            else {
                int temp = min( j==n-1 ? INT_MAX : dp[i][j+1], i==m-1 ? INT_MAX : dp[i+1][j] );
                dp[i][j] = max(temp-dungeon[i][j],1);
            }
        }
    }
    return dp[0][0];        
    }
};

// Unique Paths II leetcode.
class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {    
    int m=obstacleGrid.size();
    if(!m) return 0;
    int n=obstacleGrid[0].size();
        
    vector < vector <long long> > dp(m,vector <long long> (n,0));
    
    if(obstacleGrid[m-1][n-1]) return 0;
        
    for(int i=m-1;i>=0;i--){
        for(int j=n-1;j>=0;j--){
            if(obstacleGrid[i][j]==1) dp[i][j]=0;
            else dp[i][j] = (i==m-1 ? 0 : dp[i+1][j]) + (j==n-1 ? 0 : dp[i][j+1]); 
            if(i==m-1 && j==n-1) dp[i][j]=1;
        }
    }
    return dp[0][0];
    };
};