// 684 Redundant Connection
#include <bits/stdc++.h>

class Solution {
public:
    
    // There is a single path to go to a place. 
    vector <int> parent;

    // return parent of a vertex
    int find(int x){
        return parent[x]==x ? x: find(parent[x]);
    }
    
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
    
        int n=edges.size();
        parent.resize(n+1,0);
        
        for(int i=0;i<=n;i++){
            parent[i]=i;
        }
        
        vector <vector <int>> res;
        
        for(auto edge:edges){
            int x=find(edge[0]);
            int y=find(edge[1]);
            if(x==y) res.push_back(edge);
            else parent[y]=x;
        }
        
        return res.back();
    }
};