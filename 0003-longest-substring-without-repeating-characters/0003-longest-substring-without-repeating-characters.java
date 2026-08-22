class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max =0;
        StringBuilder sb = new StringBuilder();
        for(char ch: s.toCharArray()){
            if(sb.toString().contains(String.valueOf(ch))){
                int id = sb.toString().indexOf(ch);
                sb.delete(0,id+1);
            }
            sb.append(ch);
            max = Math.max(max,sb.length());
        }
        return max;
    }
}