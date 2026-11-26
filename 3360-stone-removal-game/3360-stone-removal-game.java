class Solution {
    public boolean canAliceWin(int n) {
        if(n<10) return false;
        if(n==10) return true;
        n=n-10;
        boolean win = true;
        int i=9;
        while(n>=0){
            n=n-i;
            if(n>=0){
                win=!win;
            }
            i--;

        }
        return win;
    }
}