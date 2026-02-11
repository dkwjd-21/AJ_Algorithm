class Solution {
    public String solution(String my_string, String letter) {
        // my_string에서 letter을 제거하여 리턴
        String answer = "";
        
        answer = my_string.replace(letter, "");
        
        return answer;
    }
}