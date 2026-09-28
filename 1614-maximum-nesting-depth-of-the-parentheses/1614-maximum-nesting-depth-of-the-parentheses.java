class Solution {
    public int maxDepth(String s) {
        int count =0;
        int maxCount = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                count++;
            }
            maxCount=Math.max(count,maxCount);
            if(ch==')'){
                count--;
            }
        }
        return maxCount;
    }
}