class Solution {

    private String isPossible(int n,int[] freqq,String curr,char mid,String target){
        int[] freq = freqq.clone();
        for(int i=25;i>=0;i--){
            while(freq[i]>0){
                curr+=(char)('a'+i);
                freq[i]--;
            }
        }
        if(mid!='#'){
            String temp = curr;
            curr+=mid;
            temp = new StringBuilder(temp).reverse().toString();
            curr+=temp;
        }else{
            String temp = curr;
            temp = new StringBuilder(temp).reverse().toString();
            curr+=temp;
        }

        return curr.compareTo(target)>0 ? curr : "";
    }

    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];

        if(n==1){
            if (s.compareTo(target)>0) return s;
            else return "";
        }
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }

        char mid='#';
        int oddCount =0;

        for(int i=0;i<26;i++){
            if(freq[i]%2!=0){
                mid = (char)('a'+i);
                freq[i]--;
                oddCount++;
            }
            freq[i]/=2;
            if(oddCount>=2) return ""; //matlab ki odd do bar nhi ana chaiye kyuki tab middle hi hoga. So, palindrome nhi form hoga.
        }
        n/=2;   // ye isliye kiya ,hume bas left half form karna hai
        String res ="",prefix ="";
        for(int i=0;i<n;i++){
            String curr = prefix;
            boolean isAny = false;

            for(int j=0;j<26;j++){
                if(freq[j]>0){
                    freq[j]--;
                    curr+=(char)('a'+j);
                    String isPoss = isPossible(n,freq,curr,mid,target);
                    if(!isPoss.equals("")){
                        prefix = curr;
                        isAny = true;
                        if(res.equals("")){
                            res=isPoss;
                        }else{
                            res=res.compareTo(isPoss)<0? res: isPoss;
                        }
                        break;
                    }
                    freq[j]++;
                    curr = curr.substring(0,curr.length()-1);
                }
            }
            if(!isAny){
                return "";
            }

        }
        return res;

    }
}