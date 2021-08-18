class Solution {
public:
    unordered_map <string,string> owners;
    unordered_map <string,string> parents;
    unordered_map <string, set<string>> unionMap;
    
    string find(string mail){
        if(parents.find(mail)==parents.end() || parents[mail]==mail ){
            return mail;    
        }
        return find(parents[mail]);
    }
    
    vector<vector<string>> accountsMerge(vector<vector<string>>& accounts) {
 
        vector<vector<string>> result;
        
        for(auto account:accounts){
            string name=account[0];
            string parentMail=account[1];
            
            for(int i=1;i<account.size();i++){
                owners[account[i]]=name;
                parents[find(account[i])]=find(parentMail);
            }
        }
        
        for(auto account:accounts){
            
            for(int i=1;i<account.size();i++){
                unionMap[find(account[i])].insert(account[i]);    
            }
        }
        
        vector <string> v;
        
        for(auto mergeAccounts: unionMap){
            v.clear();
            string ownName=owners[mergeAccounts.first];
            v.push_back(ownName);
            for(auto mail: mergeAccounts.second){
                v.push_back(mail);
            }
            result.push_back(v);
        }
        
        return result;
        
    }
};

/*
john a, b, d,m
john l, c, d,f
mary m
john t

parents:
b = a
d = a
m = a

c = l
a = l
f = l

l = l,b,d,m,c,f
m = m
t = t


*/




