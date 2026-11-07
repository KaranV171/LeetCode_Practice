class Solution {
    private int countones(int x){
        int count = 0;
        while(x!=0){
            if((x&1)!=0){
                count++;
                
            }
            x=x>>>1;
        }
        return count;
    }
    public int calculateScore(int a, int b) {
        int s1 = countones(a);
        int s2 = countones(b);
        if(s1>=s2){
            return s1*s2;
        }else{
            return s2/s1;
        }
    }
}