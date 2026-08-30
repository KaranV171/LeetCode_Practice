class Solution {
    public int minimumDeletions(int[] nums) {
        int minIdx = -1;
        int maxIdx = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max = nums[i];
                maxIdx = i;
            }
            if(nums[i]<min){
                min = nums[i];
                minIdx = i;
            }
        }
        int sum = 0;
        int front = Math.max(maxIdx,minIdx) +1;
        int middle = Math.min(maxIdx,minIdx) + 1 + (nums.length-Math.max(maxIdx,minIdx));
        sum = Math.min(front,middle);
        int back = nums.length-Math.min(minIdx,maxIdx);
        sum = Math.min(sum,back);
        return sum;
    }
}