class Solution {
    public int solution(String A, String B) {
        int answer = -1;
        int len = A.length();
        String tmp = A.charAt(len-1) + "";  // A의 가장 마지막 문자 
        
        if(A.equals(B)) return 0;
        
        for(int i=0; i<len; i++) {
            // tmp + 0부터 뒤에서 두번째 문자까지 자른 문자열
            A = tmp + A.substring(0, len-1);
            // tmp 갱신
            tmp = A.charAt(len-1) + "";
            
            // 새로 만든 A가 B와 같은지 확인 
            if(A.equals(B)) {
                answer = i+1;
                return answer;
            } 
        }
        
        return answer;
    }
}