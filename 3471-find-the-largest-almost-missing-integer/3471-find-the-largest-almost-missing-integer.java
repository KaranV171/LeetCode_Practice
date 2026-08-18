class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i+k<=nums.length;i++){
            HashSet<Integer> seen = new HashSet<>();
            for(int j=i;j<i+k;j++){
                
                seen.add(nums[j]);
            }

            for(int x : seen){
                mp.put(x,mp.getOrDefault(x,0)+1);
            }

        }
        int ans =-1;

        for(Map.Entry<Integer,Integer> entry : mp.entrySet()){
            if(entry.getValue()==1){
                ans = Math.max(ans,entry.getKey());
            }
        }
        return ans;
        
    }
}