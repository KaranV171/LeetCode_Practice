class Solution {
    private boolean check(int digit ,int i){
        int sum = 0;
        while(digit!=0){
            int r = digit%10;
            sum+=r;
            digit=digit/10;
        }
        return sum==i;
    }
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int digit = nums[i];
            if(digit<=9 && digit==i){
                return i;
            }
            boolean cond = check(digit,i);
            if(cond){
                return i;
            }
        }
        return -1;
    }
}