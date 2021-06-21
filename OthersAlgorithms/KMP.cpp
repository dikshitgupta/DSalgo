#include <bits/stdc++.h>
using namespace std;

void KMP_brute(string str,string pat){
    for(int i=0;i<str.size();i++){    
        int j=0;
        while(str[i+j]==pat[j]){
            j++;
            if(j==pat.size()){
                cout<<i<<" ";
                break;
            }
        }
    }
}


vector <int> lps(string pat){
    int M=pat.size();
    vector <int> lps(pat.size(),0);
   // length of the previous longest prefix suffix
    int len = 0;
    lps[0] = 0; // lps[0] is always 0
    // the loop calculates lps[i] for i = 1 to M-1
    int i = 1;
    while (i < M) {
        if (pat[i] == pat[len]) {
            len++;
            lps[i] = len;
            i++;
        }
        else // (pat[i] != pat[len])
        {
            // This is tricky. Consider the example.
            // AAACAAAA and i = 7. The idea is similar
            // to search step.
            if (len != 0) {
                len = lps[len - 1];
                // Also, note that we do not increment
                // i here
            }
            else // if (len == 0)
            {
                lps[i] = 0;
                i++;
            }
        }
    }
    return lps;
}

void KMP(string str,string pat){
    vector <int> lp=lps(pat);
    int i=0;
    int j=0;
    int n=str.size();
    int m=pat.size();

    while(i<n){
        if(str[i]==pat[j]){
            i++;
            j++;         
        }
        if(j==m){
         cout<<i-j<<" ";
          j=lp[j-1];
        }
        else if(i<n && pat[j]!=str[i]){
            if(j!=0){
                j=lp[j-1];
            }
            else{
                i++;
            }
        }
    }
}

/*

lps[i] = the longest common string that is suffix as well as prefix.
It stores the next indices of the comparison.

*/


int main(){
    // string str="AABAAAABAAABAAABAACAADAABAABA";
    string str="AABAAAAABAAABAAAAABAAABAAAAABAAABAAAAABAAABAAAAABAAABAAAAABAAABAAAAABAAABAAAAABAAABAAAAABAAABAAAAABAAABAAAAABAAABAAAAABAAABAAAAABAAABAAAAABAAABAAAAABAAABAAAAABAAABAAAAABAAABAAAAABAAABAAAAABAAABAAAAABA";
    
    string pat="BAAABAAAAABAAABAAAAA";
    
    // printf(" A : %s B: %s",str.c_str(),pat.c_str());      AABAACAADAABAABA    
    KMP_brute(str,pat);

    KMP(str,pat);
    return 0;
}