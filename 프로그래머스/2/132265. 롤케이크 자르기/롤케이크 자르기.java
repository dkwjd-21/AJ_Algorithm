import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int length = topping.length;
        
        // 토핑이 1개면 나눌 수 없음
        if(length == 1) return answer;
        
        // 철수가 가질 토핑 set
        HashSet<Integer> setA = new HashSet<Integer>();
        // 동생이 가지고 있는 토핑 map (토핑번호, 개수)
        HashMap<Integer, Integer> mapB = new HashMap<>();
        for(int i=0; i<length; i++) {
            mapB.put(topping[i], mapB.getOrDefault(topping[i], 0)+1);
        }
        
        // topping[i]를 철수가 먹게 되는 경우
        for(int i=0; i<length; i++) {
            // 철수 set 추가 
            setA.add(topping[i]);
            
            // 동생 map 감소 
            // 개수가 0이면 제거 
            mapB.put(topping[i], mapB.get(topping[i])-1);
            if(mapB.get(topping[i]) == 0) {
                mapB.remove(topping[i]);
            }
            
            // 공평한지 체크
            if(setA.size() == mapB.size()) answer++;
        }
        
        return answer;
    }
}