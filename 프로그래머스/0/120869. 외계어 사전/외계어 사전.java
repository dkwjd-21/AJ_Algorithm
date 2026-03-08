class Solution {
    public int solution(String[] spell, String[] dic) {
        // 알파벳이 담긴 배열 spell 
        // 외계어 사전 dic
        // spell을 한번씩만 모두 사용한 단어가 존재한다면 1, 존재하지 않는다면 2 리턴 
        int answer = 0;
        int n = spell.length;   // 스펠의 개수 
        boolean isExist = false;
        
        for(String word : dic) {
            if(word.length() < n) continue;
            
            int cnt = 0;
            
            for(int i=0; i<spell.length; i++) {
                if(word.contains(spell[i])) cnt++;
            }
            
            if(cnt == n) {
                isExist = true;
                break;
            }
        }
        
        answer = (isExist)? 1 : 2;
        return answer;
    }
}