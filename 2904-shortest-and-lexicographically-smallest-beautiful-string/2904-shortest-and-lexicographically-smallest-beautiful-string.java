class Solution {


    private boolean compare(String s1 , String s2){
        if(s1.length()!=s2.length()){
            return s1.length()<s2.length();
        }
        return s1.compareTo(s2)<0;
    }
    public String shortestBeautifulSubstring(String s, int k) {
        int ones = 0;
        for(char ch : s.toCharArray()){
            if(ch=='1') ones++;
        }
        if(ones<k) return "";
        int start = 0;
        String ans = s;
        ones =0;
        for(int end = 0;end<s.length();end++){
            if(s.charAt(end)=='1'){
                ones++;
            }
            while(ones>k){
                if(s.charAt(start)=='1') --ones;
                start++;
            }
            while(start<=end && ones==k && s.charAt(start)=='0'){
                start++;
            }
            if(ones==k){
                if(compare(s.substring(start,end+1),ans)){
                    ans = s.substring(start,end+1);
                }
            }
            


        }
        return ans;
    }
}