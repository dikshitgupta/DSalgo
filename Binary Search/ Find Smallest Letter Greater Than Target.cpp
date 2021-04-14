class Solution {
public:
    char nextGreatestLetter(vector<char>& letters, char target) {
    int n=letters.size();
    int l=0,r=n-1,mid;
    target=target;
    int ans=0;
      
    while(l<=r){
      mid=l+(r-l)/2;
      if(letters[mid]<=target){
        l=mid+1;
      }
      else{       //when that character idx is greater than target -> update ans. 
       r=mid-1;   //
       ans=mid;
      }    
    }

    return letters[ans];

    }
};