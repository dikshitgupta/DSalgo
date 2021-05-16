class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& A) {
    
    int m=A.size();
    int n=A[0].size();

    int T=0,B=m-1,L=0,R=n-1;
    vector <int> v;

    while(T<=B && L<=R){
    
        for(int i=L;i<=R;i++) v.push_back(A[T][i]);
        T++;

        for(int i=T;i<=B;i++) v.push_back(A[i][R]);
        R--;

        if(T<=B){
            for(int i=R;i>=L;i--) v.push_back(A[B][i]);
            B--;
        }

        if(L<=R){
            for(int i=B;i>=T;i--) v.push_back(A[i][L]);
            L++;
        }
    }

    return v;       
        
    }
};