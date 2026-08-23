class Solution {
    public boolean isPalindromic(String s) {
        StringBuilder sb = new StringBuilder();
        for(char ch: s.toCharArray()){
            int n = ch;
            String binaryString = String.format("%8s",Integer.toBinaryString(n)).replace(' ','0');
            sb.append(binaryString);

        }
        String original = sb.toString();
        String reverse = sb.reverse().toString();

        return original.equals(reverse);
    }
}