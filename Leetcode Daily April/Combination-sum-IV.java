class Solution {
    // int[] dp = new int[1001];
    static int[] dp = new int[1001];
    static{ 
    Arrays.fill(dp, -1);
    }
           
    int helper(int[] nums,int target,int curr){
        if(curr>target) return 0;
        if(dp[curr]!=-1) return dp[curr];
        if(curr==target){
            return 1;
        }
        int count=0;
        int n=nums.length;
        for(int i=0;i<n;i++){ 
            count+=helper(nums,target, (curr+nums[i]));   
        }
        dp[curr]=count;
        return count;
    }
    
    public int combinationSum4(int[] nums, int target) {
    return helper(nums,target,0);        
    }
}

