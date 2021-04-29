class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
    int n=nums.size();
    
    int l=0;
    int r=n-1;
    int mid;
    vector <int> v{INT_MAX,INT_MIN};
    
    while(l<=r){
        mid=(l+r)/2;
        if(nums[mid]>target){
            r=mid-1;
        }
        else{
            if(nums[mid]==target) v[1]=max(v[1],mid);
            l=mid+1;
        }
    }
    
    l=0,r=n-1;
        
    while(l<=r){
        mid=(l+r)/2;
        if(nums[mid]<target){
            l=mid+1;
        }
        else{
            if(nums[mid]==target) v[0]=min(v[0],mid);
            r=mid-1;
        }
    }
    
    if(v[0]==INT_MAX) v[0]=-1;
    if(v[1]==INT_MIN) v[1]=-1;
        
    return v;
    }
};
