#include<bits/stdc++.h>
using namespace std;

void print_arr(vector <int> v){
    for(int i=0;i<v.size();i++){
        cout<<v[i]<<" ";
    }
    cout<<endl;
    return ;
}

void perfect_sum(vector <int> v, vector <vector <int> > & z,vector <int> temp, int sum, int idx){
// Recursive function
// no of subarrays whose sum is equal to the given sum
if(sum==0) {z.push_back(temp);   return ;}
if(sum<=0 || idx==v.size()) return;

for(int i=idx;i<v.size();i++){
    temp.push_back(v[i]);
    perfect_sum(v,z,temp,sum-v[i],i+1);
    temp.pop_back();
    }
}

int main() 
{
   vector <int> v;
   for(int i=0;i<16;i++) {
       v.push_back(rand()%200);
   } 

v.push_back(1);v.push_back(3);v.push_back(5);v.push_back(6);v.push_back(7);
vector <int> temp;
vector <vector <int> > z;   
perfect_sum(v,z,temp,100,0);
for(auto i:z) print_arr(i);

}


