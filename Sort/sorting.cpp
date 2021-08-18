#include<bits/stdc++.h>
using namespace std;

void print_arr(vector <int> v){
    for(auto i:v){
        cout<<i<<" ";
    }cout<<endl;
}

//---------------------------Bubble Sort-------------------------------------------------------------------------------//
/* 
If we go through the inner loop with no swapping we can terminate our Search
Best Case is when the array is already sorted then we return after one pass.
Worst Case if the input is in descending order. O(n^2)
*/

vector <int> Bubble_sort(vector <int> &v){
    int n=v.size();
    bool swapped=false;
    do{ 
        swapped=false;
        for(int i=0;i<n-1;i++){
            if(v[i]>v[i+1]){
              swap(v[i],v[i+1]);
              swapped=true; 
            }
        }
        n--;
    }
    while(swapped==true);

    // int n=v.size();
    // for(int i=0;i<n;i++){
    //     for(int j=0;j<n-1-i;j++){
    //             if(v[j]>v[j+1]){
    //                 swap(v[j],v[j+1]);
    //             }
    //     }
    // }
    return v;
}

//---------------------------Bubble Sort-------------------------------------------------------------------------------//

//---------------------------Selection Sort-------------------------------------------------------------------------------//

//not stable
void selectionSort(vector <int> &v){
    int n=v.size();

    int maxi;
    for(int i=n-1;i>=1;i--){
        maxi=i;
        for(int j=0;j<i;j++){
            if(v[j]>=v[maxi])
                maxi=j;
        }
        swap(v[i],v[maxi]);
    }
}
//---------------------------Selection Sort-------------------------------------------------------------------------------//

//---------------------------Insertion Sort-------------------------------------------------------------------------------//
/*
Best Case: already sorted: v[j]>next will be false. so it will run o(n)
Worst case v[j]>next will be true and we have to shift all elements i.e reverse array like 5 4 3 2 1
*/

void insertionSort(vector <int> &v){
    int n=v.size();
    for(int i=1;i<n;i++){
        int next=v[i];
        int j;
        for(j=i-1;j>=0 && v[j]>next;j--)
            v[j+1]=v[j];    
        
        v[j+1]=next;
    }
}

//---------------------------Insertion Sort--------------------------------------------------------------------------------//


//---------------------------Merge Sort--------------------------------------------------------------------------------//
/*
 O(n lg(n))
 o(n) extra space required for merge function in call stack.
*/

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
//---------------------------Merge Sort----------------------------------------------------------------------------//

//---------------------------Merge Sort----------------------------------------------------------------------------//



int main() 
{
   vector <int> v;
   for(int i=0;i<3;i++) {
       v.push_back(rand()%1000);
   }
    print_arr(v);
    // mergesort(v,0,v.size()-1);
    // Bubble_sort(v);
    selectionSort(v);
    // insertionSort(v);

    print_arr(v);
    return 0;
    
}


