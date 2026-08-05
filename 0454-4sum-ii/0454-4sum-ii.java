class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        int count =0;
        for(int a : nums1){
            for(int b: nums2){
                int sum = a+b;
                mp.put(sum,mp.getOrDefault(sum,0)+1);
            }
        }

        for(int c : nums3){
            for(int d: nums4){
                int target = -(c+d);
                if(mp.containsKey(target)){
                    count+=mp.get(target);
                }
            }
        }
        return count;
    }
}