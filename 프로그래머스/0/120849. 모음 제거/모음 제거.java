class Solution {
    public String solution(String my_string) {
        // 모음을 제거한 문자열 리턴 
        String answer = "";
        String vowel[] = {"a", "e", "i", "o", "u"};
        
        for(int i=0; i<vowel.length; i++) {
            my_string = my_string.replace(vowel[i], "");
        }
        
        return answer = my_string;
    }
}