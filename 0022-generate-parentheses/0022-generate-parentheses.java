class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res,"",0,0,n);
        return res;
    }

    public void helper(List<String> list,String s,int open,int close,int n){
        if(s.length()==2*n){
            list.add(s);
            return;
        }
        if(open<n){
            helper(list,s+"(",open+1,close,n);
        }
        if(close<open){
            helper(list,s+")",open,close+1,n);
        }
    }
}