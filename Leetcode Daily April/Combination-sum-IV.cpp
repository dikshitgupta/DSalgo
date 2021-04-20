#include <bits/stdc++.h>
using namespace std;
// DP solution with top down / memoization approach
class Solution {
public:
    int helper(vector <int> &nums,int target,int curr,vector <int> &dp){
        if(curr>target) return 0;
        if(dp[curr]!=-1) return dp[curr];
        if(curr==target){
            return 1;
        }
        int count=0;
        int n=nums.size();
        for(int i=0;i<n;i++){ 
            count+=helper(nums,target, (curr+nums[i]),dp);   
        }
        dp[curr]=count;
        return count;
    }
    
    int combinationSum4(vector<int>& nums, int target) {
    vector <int> dp(target+1,-1);
    return helper(nums,target,0,dp);
    }
};