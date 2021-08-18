#include<bits/stdc++.h>
using namespace std;

void bfs(int s, int n, vector <int> adj[]){
    queue <int> q;
    q.push(s);
    vector <bool> vis(n,false);
    vis[s]=true;

    while(!q.empty()){ //
    int temp=q.front();
    cout<<temp<<" ";
    q.pop();
    
    for(int i=0;i<adj[temp].size();i++){
           if(vis[adj[temp][i]]==false){
            vis[adj[temp][i]]=true;
            q.push(adj[temp][i]);
        }
    }
    }
}

bool cycle_util(int s,vector <bool > vis, vector <int> adj[]){
    vis[s]=true;
    bool flag;
    for(int i=0;i<adj[s].size();i++){
        if(vis[adj[s][i]]==true){
            return true;
        }
        else flag=cycle_util(adj[s][i],vis,adj);
        if(flag==true) return flag;
    }
    vis[s]=false;
    return false;
}

// 0->1    
// 1
// 2->1->3
// 3->4
// 4->0->2

void is_cycle(vector <bool> vis,vector <int> adj[]){
int flag=0;

for(int i=0;i<vis.size();i++){
    flag=cycle_util(i,vis,adj);
    if(flag==true){
        cout<<"cycle exists, start at pos: "<<i;
        flag=false;
    }
}
}

void topo_dfs(vector <int> adj[] ,int n){

vector <bool> vis(n,false);
vector <int> in_degree(n,0);
for(int i=0;i<n;i++){
    for(int j=0;j<adj[i].size();j++){
        in_degree[adj[i][j]]++;
        // cout<<"i "<<adj[i][j]<<"indegree "<<in_degree[adj[i][j]]<<endl;
    }
}

queue <int> q;
for(int i=0;i<n;i++){
    if(in_degree[i]==0) q.push(i);
} 

int cnt=0; // count of traversed edges.

while(!q.empty()){
    int u=q.front();
    q.pop();
    cout<<" "<<u<<" ";
    vis[u]=true;
    for(int i=0;i<adj[u].size();i++){
        --in_degree[adj[u][i]];
        if(in_degree[adj[u][i]]==0 && !vis[adj[u][i]]) 
            q.push(adj[u][i]);
    }
    cnt++;
}

if(cnt!=n) cout<<"cycle exists";

}


int main() 
{

char a='a';
int N=4;
vector <bool> vis(N,false);
vector<int> adj[N];
adj[0].push_back(1);  adj[0].push_back(2);
adj[2].push_back(3);
adj[3].push_back(1);

// bool cycle=false;
topo_dfs(adj,4);
return 0;

}

// Letter Toggling
// a=a^(1<<5);
// cout<<a;
// a='A';
// a=a^(1<<5);
// cout<<a;
// 



