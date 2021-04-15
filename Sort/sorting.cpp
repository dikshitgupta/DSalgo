#include<bits/stdc++.h>
using namespace std;

void print_arr(vector <int> v){
    for(auto i:v){
        cout<<i<<" ";
    }cout<<endl;
}

vector <int> Bubble_sort(vector <int> v){
    int n=v.size();
    for(int i=0;i<n;i++){
        for(int j=0;j<n-1-i;j++){
                if(v[j]>v[j+1]){
                    swap(v[j],v[j+1]);
                }
        }
    }
    return v;
}

void merger_function (vector <int> & v,int l,int m,int r){
int k=0;
int i=l;
int j=m+1;
vector <int> temp(r-l+1,0);
for(int t=l ; t<=r; t++){
    if(i>m) {
        temp[k]=v[j];
        j++; 
        k++;
    } 
    else if(j>r) {
        temp[k]=v[i];
        i++; 
        k++;
    } 
    else if(v[i]>v[j]){
        temp[k]=v[j];
        j++;
        k++;
    }
    else {
        temp[k]=v[i];
        i++;
        k++;        
    }
}

    for(int i=0;i<r-l+1;i++){
        v[l+i] = temp[i]; 
    }

}

void mergesort(vector <int> &v, int l, int r){
    if(l>=r) return;
    int m = l+ (r-l)/2;
    mergesort(v,l,m);
    mergesort(v,m+1,r);
    merger_function(v,l,m,r);
}

int main() 
{
   vector <int> v;
   for(int i=0;i<60;i++) {
       v.push_back(rand()%20);
   }
    cout<<"orignial: ";
    // mergesort(v,0,v.size()-1);
    v=Bubble_sort(v);
    print_arr(v);
    cout<<"sorted the array";
    return 0;
}


