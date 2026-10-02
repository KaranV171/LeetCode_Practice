class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res,"",0,0,n);
        return res;
    }
    private void helper(List<String> res,String str , int open,int close, int n){
        if(str.length()==2*n){
            res.add(str);
            return;
        }
        if(open<n){
            helper(res,str+"(",open+1,close,n);
        }
        if(close<open){
            helper(res,str+")",open,close+1,n);
        }
    }
}