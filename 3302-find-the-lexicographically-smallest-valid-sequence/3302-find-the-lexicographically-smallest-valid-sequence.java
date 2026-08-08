class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] ans = new int[m];
        
        java.util.Arrays.fill(ans, -1);
        int i=n-1,j=m-1;
        while(i>=0 && j>=0){
            if(word1.charAt(i)==word2.charAt(j)){
                ans[j]=i;
                j--;
            }
            i--;
        }

        int[] res = new int[m];
        int size=0;
        boolean change=true;
        j=0;
        for(int i=0;i<n && j<m;++i){
            if(word1.charAt(i)==word2.charAt(j)){
                res[size++]=i;
                j++;
            }else if(change && (j==m-1|| i<ans[j+1])){
                change = false;
                res[size++]=i;
                j++;
            }
        }
        if(j==m){
            return res;
        }
        return new int[0];



    }
}