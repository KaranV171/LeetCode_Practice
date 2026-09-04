class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0]=nums[0];
        for(int i=1;i<n;i++){
            ans[i]=Math.max(nums[i],ans[i-1]);
        }

        int min = Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--){
            min = Math.min(nums[i],min);
            ans[i]-=min;
        }

        for(int i=0;i<n;i++){
            if(ans[i]<=k){
                return i;
            }
        }
        return -1;
    }
}