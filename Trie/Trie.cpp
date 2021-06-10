#include <bits/stdc++.h>
using namespace std;
class Trie {
public:
    /** Initialize your data structure here. */
    Trie * arr[128]; 
    bool endOfWord;

    Trie() {
        this->endOfWord=false;
        for(int i=0;i<128;i++){
            this->arr[i]=NULL;
        }
        cout<<"fkin constructsor"<<endl;
    }
    
    /** Inserts a word into the trie. */
    void insert(string word) {
        Trie * temp=this;
        for(char ch:word){
            if(temp->arr[ch-'A']==NULL){
                temp->arr[ch-'A']=new Trie();
            }
            temp=temp->arr[ch-'A'];
        }
        temp->endOfWord=true;
    }
    
    /** Returns if the word is in the trie. */
    bool search(string word) {
         Trie * temp=this;
        for(char ch: word){
            if(temp->arr[ch-'A']!=NULL){
            temp=temp->arr[ch-'A'];
            }
            else return false;
        }
        if(temp->endOfWord==true) return true;
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    bool startsWith(string prefix) {
        Trie * temp=this;
        for(char ch:prefix){
            if(temp->arr[ch-'A']!=NULL){
            temp=temp->arr[ch-'A'];
            }
            else return false;
        }
        return true;
    }

};
/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */
int main(){
Trie *obj=new Trie();
cout<<"size is :"<<sizeof(*obj)<<endl;
obj->insert("dikshit");
obj->insert("dravid");
cout<<obj->search("diksh")<<endl;
cout<<obj->search("dikshit")<<endl;
cout<<obj->startsWith("dravi");
return 0;
}