class Solution {
    public String solution(String s) {
        // JadenCase : 첫 문자가 대문자, 그 외의 알파벳은 소문자인 문자열
        StringBuilder sb = new StringBuilder();
        
        boolean isFirst = true;
        
        for(char ch : s.toLowerCase().toCharArray()) {
            if(ch == ' ') {
                sb.append(ch);
                isFirst = true;
            } else if(isFirst) {
                sb.append(Character.toUpperCase(ch));
                isFirst = false;
            } else {
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}