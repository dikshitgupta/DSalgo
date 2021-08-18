class Solution {
public:
    vector <int> parent;
    int count=0;
    
    int removeStones(vector<vector<int>>& stones) {
        int n=1000;
        
        parent.resize(n+1,-1);
        for(int i=0;i<=n;i++){
            parent[i]=i;
        }
    
        for(int i=0;i<stones.size();i++){
            for(int j=i+1;j<stones.size();j++){
                if(stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1] ){
                    union_it(i,j);
                }
            }   
        }
        return count;
    }
    
    void union_it(int x,int y){
        int parent_x=find(x);
        int parent_y=find(y);
     
        if(parent_x==parent_y){
            return;    
        }
        
        parent[parent_y]=parent_x;
        count++;
        return;
    }
    
    int find(int x){
        while(x!=parent[x]){
            x=parent[x];
        }
        return x;
    } 
    
    
};
