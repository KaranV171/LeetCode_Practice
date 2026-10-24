class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int a1 = convert(arriveAlice);
        int a2 = convert(leaveAlice);
        int b1 = convert(arriveBob);
        int b2 = convert(leaveBob);

        int start = Math.max(a1,b1);
        int end = Math.min(a2,b2);
        return Math.max(0,end-start+1);
    }

    private int convert(String s){
        int[] days={0,31,28,31,30,31,30,31,31,30,31,30,31};
        int m = Integer.parseInt(s.substring(0,2));
        int d = Integer.parseInt(s.substring(3));
        for(int i=1;i<m;i++){
            d+=days[i];
        }
        return d;
    }
}