#include<bits/stdc++.h>
using namespace std;

vector <int> parent;

// finding if there is a cycle in undirected graph.
// can't be used for directed graph

int find(int x){
    if(parent[x]==-1){
        return x;
    }
    return find(parent[x]);
}

void union_it(int x,int y){
    parent[y]=x;    
}

bool is_cycle(vector <pair <int,int> > edges){
    for(auto edge:edges){
        int x=find(edge.first);  // find absolute parent of edge.first
        int y=find(edge.second);
        if(x==y){
            cout<<"x "<<x<<" y "<<y<<endl;
            return true;
        }
        union_it(x,y);
    }
    return false;
}

int main(){

    int E,V;
    cin>>E>>V;

    parent.resize(V,-1);
    vector <pair <int,int> > edges;

    for(int i=0;i<E;i++){
        int x,y;
        cin>>x>>y;
        edges.push_back(make_pair(x,y));
    }

    cout<<is_cycle(edges);

for(auto p:parent) cout<<p<<" ";

return 0;
}