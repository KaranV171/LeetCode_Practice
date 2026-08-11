class Solution {
    public int missingInteger(int[] nums) {
        int sum =nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]+1){
                sum+=nums[i];
            }else{
                break;
            }
        }

        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int num : nums){
            mp.put(num,1);
        }

        while(mp.containsKey(sum)){
            sum++;
        }
        return sum;
    }
}