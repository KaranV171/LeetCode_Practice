class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        // int num = 2;
        int missing =0;
        int i=1;
        while(true){
            int find = k*i;
            if(!set.contains(find)){
                missing = find;
                break;
            }
            i++;
        }
        return missing;
    }
}