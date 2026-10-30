class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int n = chars.length;
        sb.append(chars[0]);
        int count = 1;
        for(int i=1;i<n;i++){
            if(chars[i-1]==chars[i]){
                count++;
            }else{
                if(count>1){
                    sb.append(count);
                    
                }
                sb.append(chars[i]);
                count=1;
            }
        }
        if (count > 1) {
            sb.append(count);
        }

        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }
        return sb.length();
    }
}