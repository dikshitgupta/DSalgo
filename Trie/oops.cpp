#include <bits/stdc++.h>
using namespace std;

class Student{
public:
    string name;
    int height; // height in cms
};

struct Dog{
    string breed;
    int height; 
};


Dog setHeight(Dog &d){
    d.height = 5;
    cout<<&d<<endl;
    return d;
}


int main(){

    Dog pilloo;
    pilloo.breed="bhotiya";

    cout<<"pillo address is "<<&pilloo<<endl;
    
    Dog b=setHeight(pilloo);

    printf("dog name %s height %d",b.breed.c_str(),b.height);

    return 5;
}