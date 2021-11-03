#include<bits/stdc++.h>
using namespace std;


// void print_arr(vector <int> v){
//     for(auto i:v){
//         cout<<i<<" ";
//     }cout<<endl;
// }

// longest palindromic subsequence
// dp with memoizations....
int lps(string s,vector <vector <int> >& dp,int i,int j){          // Longest Palndromic subsequence
    if(dp[i][j]!=-1) return dp[i][j];
    if(i==j) dp[i][j]=1;
    else if (i>j) dp[i][j]=0;
    else if(s[i]==s[j]) dp[i][j]=2+ lps(s,dp,i+1,j-1);
    else dp[i][j]= max(lps(s,dp,i+1,j),lps(s,dp,i,j-1));
    return dp[i][j];
}

int main() 
{
    string s="asdfffffasdfefrdasdfghjfdgdefrdaf";
    int n=s.size();
    vector < vector <int> > v(n, vector <int> (n,-1) );
    getline(cin,s);
    cout<<lps(s,v,0,s.size()-1);
    return 0;
}


