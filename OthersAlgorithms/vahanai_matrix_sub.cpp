#include <bits/stdc++.h>
using namespace std;


int largestSubgrid(vector< vector<int> > grid, int maxSum) {
    
    int n=grid.size();
    vector <vector <int> > dp(n, vector <int> (n,0));
    
    // column sum
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            dp[i][j]+= grid[i][j] + (j>0 ? dp[i][j-1]: 0) ;
        }        
    }
    
    // row sum
    for(int j=0;j<n;j++){
        for(int i=1;i<n;i++){
            dp[i][j]+=  dp[i-1][j] ;
        }        
    }
       
    // subgrid size , sum; maxSum
    
    unordered_map<int, int> nap;
    
    // k is size of the grid
    
    for(int k=1;k<=n;k++){
        
        for(int i=k-1;i<n;i++){
            for(int j=k-1;j<n;j++){
                int i0=i-k+1;
                int j0=j-k+1;
    
                int newsum;
                if(i0==0 && j0==0) newsum=dp[i][j];                
                else if(i0==0) newsum=dp[i][j]-dp[i][j0-1];
                else if(j0==0) newsum=dp[i][j]-dp[i0-1][j];
                else  newsum= dp[i][j] + dp[i0-1][j0-1] - dp[i][j0-1] - dp[i0-1][j];
                int currSum= nap.find(k)!=nap.end() ? nap[k] : 0;
                if(newsum>currSum) nap[k]=newsum;
            }
        }
    }
        
    int ans=0;
    
    for(auto value: nap){
        cout<<value.first<<" "<<value.second<<endl;
        if(value.second<=maxSum) ans=max(ans,value.first);
    }
    
    return ans;

}

int main(){

    vector < vector < int > > matrix{ { 1, 1, 1 }, { 1, 1, 1 },{ 1, 1, 1 } };
    // cout<<v[0];
    int maxSum=4;
    cout<<largestSubgrid(matrix,maxSum);
    return 0;
}