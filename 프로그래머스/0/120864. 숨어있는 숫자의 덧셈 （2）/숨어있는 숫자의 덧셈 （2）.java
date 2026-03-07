class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        my_string = my_string.replaceAll("[a-zA-Z]", " ");
        // " +" : 공백이 1개 이상 반복됨을 의미하는 정규표현식
        String[] strArr = my_string.trim().split(" +");
        
        if(my_string.trim().isEmpty()) return answer;
        
        for(String str : strArr) {
            answer += Integer.parseInt(str);
        }
        
        return answer;
    }
}