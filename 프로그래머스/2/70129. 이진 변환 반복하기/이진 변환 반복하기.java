class Solution {
    public int[] solution(String s) {
        // 이진 변환의 횟수와 변환 과정에서 제거된 모든 0의 개수
        int[] answer = new int[]{0, 0};
        
        while(!s.equals("1")) {
            // 0의 개수. 
            answer[1] += s.length() - s.replace("0", "").length(); 
            // 0 제거
            s = s.replace("0", "");
            
            // 길이를 2진법으로 표현한 문자열 
            int len = s.length();
            s = Integer.toBinaryString(len);
            answer[0]++;    // 변환 횟수
        }
        
        
        return answer;
    }
}