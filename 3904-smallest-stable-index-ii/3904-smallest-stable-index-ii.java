class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        arr[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            int min = Math.min(nums[i],arr[i+1]);
            arr[i]=min;
        }
        for(int i=0;i<n;i++){
            max=Math.max(nums[i],max);
            if(max - arr[i]<=k){
                return i;
            }
        }
        return -1;
    }
}