class Solution {
    public int minimumDeletions(int[] nums) {
        int minIdx = 0;
        int maxIdx = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>nums[maxIdx]){
                maxIdx = i;
            }
            if(nums[i]<nums[minIdx]){
                minIdx = i;
            }
        }
        int sum = 0;
        int front = Math.max(maxIdx,minIdx) +1;
        int middle = Math.min(maxIdx,minIdx) + 1 + (nums.length-Math.max(maxIdx,minIdx));
        int back = nums.length-Math.min(minIdx,maxIdx);
        sum = Math.min(front,middle);
        sum = Math.min(sum,back);
        return sum;
    }
}