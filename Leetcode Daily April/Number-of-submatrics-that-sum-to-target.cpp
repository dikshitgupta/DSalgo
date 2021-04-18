class Solution {
public:
    int numSubmatrixSumTarget(vector<vector<int>>& matrix, int target) {
  
    int count=0;
    unordered_map <int,int> nap;
    int curr=0;
        
    // Step 1: Calculate the prefix sum for each row.
    int m=matrix.size();
    int n=matrix[0].size();
    
    for(int i=0;i<m;i++){
        for(int j=1;j<n;j++){
            matrix[i][j]+=matrix[i][j-1];
        }
    }
    
    // Creating all the submatrixes from i to jth column both inclusive.
    //  for those columns we will interave over all the submatrics with k from 0 to m; [0,[i---j]], [1,[i---j]] , [2,[i---j]] all submatrices.
    for(int i=0;i<n;i++){
        for(int j=i;j<n;j++){
            curr=0;
            nap={{0,1}};
            for(int k=0;k<m;k++){
                curr+= matrix[k][j] - (i>0 ? matrix[k][i-1] : 0);
                count+= nap.find(curr-target)!=nap.end() ? nap[curr-target]: 0;
                nap[curr]= 1 + (nap.find(curr)!=nap.end() ? nap[curr]: 0 );
            }
        }
    }
    
    return count;
    }
};