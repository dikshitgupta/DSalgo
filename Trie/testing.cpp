#include <bits/stdc++.h>
using namespace std;

int main(){

    int n;
	cin>>n;
	int A[n];
	
    for(int i=0;i<n;i++) cin>>A[i];

    if(n==1) {
        cout<<"TRUE";
         return 0;
    }

    int prev=0;
    int i=1;
    while(i<n)
	{
        // cout<<prev<<" ";
		if(A[i]<=prev){
            i++;
            cout<<"NO";
            return 0;
        }
        else{
            for(int num=prev+1;i<=sqrt(A[i]);num++){
                if(A[i]%num==0){
                    A[i]=num;
                    prev=A[i];
                    break;
                }
            }
            i++;
            prev= (prev==A[i-2] ? A[i-1] : prev); 
        }
	}

    // for(auto num:A){
    //     cout<<num<<" ";
    // }
    // cout<<endl;

    if(i==n) cout<<"YES";
	return 0;
}