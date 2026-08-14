class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int[] count = new int[256];
        int left =0;
        int ans =0;
        for(int right =0;right<n;right++){
            char ch = s.charAt(right);
            count[ch]++;
            while(count[ch]>2){
                count[s.charAt(left)]--;
                left++;
            }
            ans = Math.max(ans,right-left+1);
        }
        return ans;

    }
}