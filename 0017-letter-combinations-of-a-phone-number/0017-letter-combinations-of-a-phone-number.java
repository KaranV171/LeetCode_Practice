class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        pad("", digits, result);
        return result;
    }

    private void pad(String p, String up, List<String> result) {
        if (up.isEmpty()) {
            result.add(p);
            return;
        }

        String[] map = {
            "",     
            "",  
            "abc",  
            "def",  
            "ghi",  
            "jkl",  
            "mno",  
            "pqrs", 
            "tuv",  
            "wxyz"  
        };

        int digit = up.charAt(0) - '0';
        String letters = map[digit];

        for (int i = 0; i < letters.length(); i++) {
            pad(p + letters.charAt(i), up.substring(1), result);
        }
    }
}