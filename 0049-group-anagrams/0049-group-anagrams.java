class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> mp = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);
            mp.putIfAbsent(s,new ArrayList<>());
            mp.get(s).add(strs[i]);
        }

        List<List<String>> groups = new ArrayList<>(mp.values());
        // groups.sort((a,b)->a.get(0).compareTo(b.get(0)));
        return groups;

    }
}