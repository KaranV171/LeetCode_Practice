class Solution {
    public int lengthOfLongestSubstring(String s) {
        // int max =0;
        // StringBuilder sb = new StringBuilder();
        // for(char ch: s.toCharArray()){
        //     if(sb.toString().contains(String.valueOf(ch))){
        //         int id = sb.toString().indexOf(ch);
        //         sb.delete(0,id+1);
        //     }
        //     sb.append(ch);
        //     max = Math.max(max,sb.length());
        // }
        // return max;


        int max =0;
        HashSet<Character> mp = new HashSet<>();
        int left =0;
        for(int right=0;right<s.length();right++){
            while(mp.contains(s.charAt(right))){
                mp.remove(s.charAt(left));
                left++;
            }
            mp.add(s.charAt(right));
            max = Math.max(max,right-left+1);

        }
        return max;
    }
}