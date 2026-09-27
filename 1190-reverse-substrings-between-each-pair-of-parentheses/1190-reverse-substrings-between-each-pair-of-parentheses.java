class Solution {
    static void reverse(char[] ch,int i,int j){
        while(i<j){
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
    }
    public String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] ch = s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(ch[i]=='('){
                stack.push(i);
            }else if(ch[i]==')'){
                int j = stack.pop();
                reverse(ch,j+1,i-1);
            }
        }
        StringBuilder ans = new StringBuilder();
        for(char x : ch){
            if(x!='(' && x!=')'){
                ans.append(x);
            }
        }
        return ans.toString();


    }
}