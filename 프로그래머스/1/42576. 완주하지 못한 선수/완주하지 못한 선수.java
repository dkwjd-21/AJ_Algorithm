import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // participant : 참가자
        // completion : 완주자
        
        String answer = "";
        
        // 참가자 명단과 상태값(참가++. 완주--)
        Map<String, Integer> participants = new HashMap<>();
        
        // 참가자 순회
        for(String name : participant) {
            // getOrDefault(key, defaultValue)
            participants.put(name, participants.getOrDefault(name, 0)+1);
        }
        
        // 완주자 순회
        for(String name : completion){
            participants.put(name, participants.get(name)-1);
        }
        
        // 완주 못한 사람 추출
        for(String name : participants.keySet()){
            if(participants.get(name) != 0) {
                answer = name;
                break;
            }
        }
        
        return answer;
    }
}

