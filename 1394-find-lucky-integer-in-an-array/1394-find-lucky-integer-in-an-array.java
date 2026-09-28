class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int x :arr){
            mp.put(x,mp.getOrDefault(x,0)+1);
        }
        int largest = -1;
        
        for(Map.Entry<Integer,Integer> entry : mp.entrySet()){
            if(entry.getKey().equals(entry.getValue())){
                largest=Math.max(largest,entry.getKey());
            }
        }
        return largest;
        
    }
}