class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer,Set<Integer>> mp = new HashMap<>();
        for(int[] num : reservedSeats){
            int row = num[0];
            int seat = num[1];

            if(!mp.containsKey(row)){
                mp.put(row,new HashSet<>());
            }
            mp.get(row).add(seat);
        }

        int result = (n - mp.size())*2;

        for(Set<Integer> seats : mp.values()){
            boolean left = true;
            boolean right = true;
            boolean middle = true;

            for(int num : new int[]{2,3,4,5}){
                if(seats.contains(num)){
                    left = false;
                }
            }
            for(int num : new int[]{4,5,6,7}){
                if(seats.contains(num)){
                    middle = false;
                }
            }
            for(int num : new int[]{6,7,8,9}){
                if(seats.contains(num)){
                    right = false;
                }
            }
            if(right && left){
                result+=2;
            }
            else if(left || right || middle){
                result+=1;
            }
        }
        return result;

        
    }
}