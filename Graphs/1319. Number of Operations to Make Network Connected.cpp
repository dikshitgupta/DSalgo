class Solution {
public:
    
    vector <int> parent;
    
    // return parent of a vertex
    int find(int x){
        // return parent[x]==x ? x: find(parent[x]);
        while(parent[x]!=x){
            x=parent[x];
        }
        return x;
    }
    
    
    int makeConnected(int n, vector<vector<int>>& connections) {
        if(connections.size()<n-1) return -1;
        
        // find disconnected components. 
        // if total no of connections>n-1 then it can be connected otherwise return -1;
        // number of disconnected components = total number of new connections  to change.
        
        parent.resize(n+1,0);
        
        for(int i=0;i<=n;i++){
            parent[i]=i;
        }
        
    
        for(auto edge:connections){
            int x=find(edge[0]);
            int y=find(edge[1]);
            if(x==y) continue;
            else parent[y]=x;
        }
        
        unordered_map <int,int> counter;
        
        for(int i=0;i<n;i++){
            counter[find(i)]++;    
        }
        
        
        return counter.size()-1;
        
    }
};