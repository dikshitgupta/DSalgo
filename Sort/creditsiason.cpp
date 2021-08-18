
#include<bits/stdc++.h>
#include<unordered_map>
using namespace std;

// int fib(int n){
//     int a=1;
//     int b=2;

//     // nth step;

//     for(int i=3;i<=n;i++){
//         b=a+b;   // 3    5
//         a=b-a;     //2    3
//     }
//     return b;
// }
// abcdaab

// int substr(string s){
//     unordered_map <char,int> nap;
//     int ans=0;
//     int start=0;
//         for(int i=0;i<s.size();i++){
//             if(nap.find(s[i])!=nap.end()){
//                 start=max(start,nap[s[i]]);
//             }
//             nap[s[i]]=i+1;
//             ans=max(i-start+1,ans);
//         }
//     return ans;
// }

// set= d a b 
// 2
// // dabdasd"
// i- 1
// j- 3
// 0123456
// // "dddabcdeffas";

// // "abcdadefgjkl"

// // start=-1. 0, 3

// // a  4
// // b  1
// // c  2
// // d  5

// countisland=2

// i= o to n-1
//     j = 0 to n-1  

// i:2
// j:1


// ["1","1","1"]
// ["1","0","0"]
// ["1","0","1"]


// grid = [
//   ["1","1","1","1","0"],
//   ["1","1","0","1","0"],
//   ["1","1","0","0","0"],
//   ["0","0","0","0","0"]
// ]
// no of island

void recur(vector <vector <int> > &v,int i,int j){
    int m=v.size();
    int n=v[0].size();
   

    if(i<0 || i>=m || j<0 || j>=n) return;
    if(v[i][j]==1){
        v[i][j]=-1;
        recur(v,i+1,j);
        recur(v,i,j+1);
        recur(v,i-1,j);
        recur(v,i,j-1);
    }
return;
}

int main(){

    vector <vector <int> > cord(3,vector<int>(3,1));
    // int count=0;
    // int m=cord.size();
    // int n=cord[0].size();

    // cord[1][1]=0;
    // cord[1][2]=0;
    // cord[2][1]=0;

    // for(int i=0;i<m;i++) {
    //     for(int j=0;j<n;j++){
    //         if(cord[i][j]==1){
    //             count++;
    //             recur(cord,i,j);
    //         }
    //     }
    // }
    // cout<<"count: "<<count;

    

}



