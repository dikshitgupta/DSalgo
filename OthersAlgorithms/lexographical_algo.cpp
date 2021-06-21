
#include <bits/stdc++.h>
#include <vector>
using namespace std;


vector<int> compare(vector <int> v1,vector <int> v2){
    string a;
    string b;
    for(auto num:v1) a.push_back('0'+num);

    for(auto num:v2) a.push_back('0'+num);
    
    cout<<a<<"   ";

    if(a.size()!=b.size()) return (a.size()>b.size() ? v1 : v2 );
    else{
        for(int i=0;i<a.size();i++){
            if(a[i]>b[i]) return v1;
            if(a[i]<b[i]) return v2;
        }
    }
    return v1;
}


int main(){
    vector<int> v;
    int n;
    cin>>n;
    int temp;
    for(int i=0;i<n;i++){
        cin>>temp;
        v.push_back(temp);
    }
    vector <int> maxx=v;

    for(int i=0;i<v.size()-1;i++){
        int x=v.front();
        v.erase(v.begin()+0,v.begin()+1);
        v.push_back(x);
        maxx=compare(v,maxx);
    }    

    for(auto num:maxx){
        cout<<num<<" ";
    }
}