import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // participant : 마라톤에 참여한 선수들의 이름 배열
        // completion : 완주한 선수들의 이름 배열 
        // 완주하지 못한 선수의 이름 return 
        String answer = "";
        
        HashMap<String, Integer> particiMap = new HashMap<>();
        
        // 참가자 이름별 카운트 
        for(String name : participant) {
            particiMap.put(name, particiMap.getOrDefault(name, 0)+1);
        }
        
        // 완주자 이름 카운트 감소
        for(String name : completion) {
            particiMap.put(name, particiMap.get(name)-1);
        }
        
        // 완주 못한 선수 찾기
        for(String name : particiMap.keySet()) {
            if(particiMap.get(name) > 0) {
                answer = name;
                break;
            }
        }
        
        
        return answer;
    }
}