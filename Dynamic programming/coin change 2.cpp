

Return the number of combinations that make up that amount
class Solution {
public:
//      vector <vector <int> > dp(amount+1,vector <int> (coins.size(),-1) );
        
//     return cc(amount,coins.size()-1,coins,dp);
   
    // top down
    // int cc(int amount,int n,vector <int>& coins,vector <vector <int> >& dp){
    //     if(amount==0) return 1;
    //     if(amount<0) return 0;
    //     if(amount>0 and n<0) return 0;
    //     if(dp[amount][n]!=-1) return dp[amount][n];
    //     dp[amount][n]=cc(amount,n-1,coins,dp)+ cc(amount-coins[n],n,coins,dp);
    //     return dp[amount][n];
    // }
    
//     int change(int amount, vector<int>& coins) {
  
//     vector <vector <int> > dp(amount+1,vector <int> (coins.size()+1,0));
//     for(int i=0;i<=amount;i++) dp[i][0]=0;
//     for(int i=0;i<=coins.size();i++) dp[0][i]=1;
        
//     for(int i=1;i<=amount;i++){
//         for(int j=1;j<=coins.size();j++){
//             dp[i][j] = (i >= coins[j-1] ? dp[i-coins[j-1]][j] : 0) + dp[i][j-1];
//         }
//     }
//     return dp[amount][coins.size()];
//     }
    
    int change(int amount, vector<int>& coins) {

    vector <int>  dp(amount+1,0);
    dp[0]=1;
    
    for(int i=0;i<coins.size();i++){
        for(int j=coins[i];j<=amount;j++){
            dp[j] +=  dp[j-coins[i]] ;
        }
    }
   
    return dp[amount];    
    }
};