class Solution {
    public int solution(String before, String after) {
        // before의 순서를 바꾸어 after를 만들 수 있으면 1, 없으면 0 리턴
        int answer = 0;
        
        for(int i=0; i<after.length(); i++) {
            String tmp = after.charAt(i) + "";
            // replaceFirst : 처음 나오는 음절만 대체
            before = before.replaceFirst(tmp, "");
        }
        
        if(before.isEmpty()) {
            answer = 1;
        } 
        
        return answer;
    }
}