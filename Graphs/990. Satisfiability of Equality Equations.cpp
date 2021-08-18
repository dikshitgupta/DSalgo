class Solution {
public:
    vector <int> parent;
    
    int find(int x){
        return (parent[x]==x || parent[x]==-1)  ? x: find(parent[x]);
    }
    
    bool equationsPossible(vector<string>& equations) {
        
        parent.resize(26,0);
        for(int i=0;i<26;i++) parent[i]=-1;
        
        for(string eq: equations){
            int pos1=eq[0]-'a';
            int pos2=eq[3]-'a';
            char symbol=eq[1];
            
            if(symbol=='='){
                int par1=find(pos1);
                int par2=find(pos2);
                parent[par2]=par1;
            }
        }
        
        for(string eq: equations){
            int pos1=eq[0]-'a';
            int pos2=eq[3]-'a';
            char symbol=eq[1];
            
            if(symbol=='!'){
                int par1=find(pos1);
                int par2=find(pos2);
                if(par1==par2) return false;
            }
        }
        
        
        return true;
    }
};

