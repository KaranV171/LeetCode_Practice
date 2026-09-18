class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] start = new int[26];
        Arrays.fill(start,-1);
        int[] end = new int[26];
        boolean[] isValid = new boolean[26];
        Arrays.fill(isValid, true);
        List<String> ans = new ArrayList<>();

        for(int i=0;i<n;i++){
            int idx = s.charAt(i)-'a';
            if(start[idx]==-1){
                start[idx]=i;
            }
            end[idx]=i;
        }

        for(int c=0;c<26;c++){
            if(start[c]==-1) continue;

            for(int i=start[c];i<=end[c];i++){
                if(start[s.charAt(i)-'a']<start[c]){
                    isValid[c] = false;
                    break;
                }
                end[c]=Math.max(end[c],end[s.charAt(i)-'a']);
            }
        }

        int lastsubstring = Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--){
            int idx = (s.charAt(i)-'a');
            if(!isValid[idx]) continue;
            if(i==start[idx] && end[idx]<lastsubstring){
                ans.add(s.substring(i,end[idx]+1));
                lastsubstring = i;
            }

        } 
        return ans;
    }
}