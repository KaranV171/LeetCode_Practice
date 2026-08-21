class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int longest =0;

        for(int n : set){
            if(!set.contains(n-1)){
                int length =1;
                while(set.contains(n+length)){
                    length++;
                }
                longest = Math.max(longest,length);
            }
        }
        return longest;
    }
}