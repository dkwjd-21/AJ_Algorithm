import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        // want : 원하는 제품 
        // number : 원하는 수량
        // discount : 마트에서 할인하는 제품 
        // 회원등록 가능한 날짜의 총 일수 return 
        int answer = 0;
        
        // 원하는 제품 map (제품명, 인덱스)
        HashMap<String, Integer> hashmap = new HashMap<>();
        for(int i=0; i<want.length; i++) {
            hashmap.put(want[i], i);
        } 
        
        for(int i=0; i<discount.length; i++) {
            // i~i+9일 동안 원하는 제품을 살 수 있는 개수
            int[] count = new int[want.length];
                
            // i+1일에 가입했을 때, 10일 동안 할인하는 품목 & 원하는 제품 체크
            for(int j=i; j<i+10; j++) {
                if(j >= discount.length) continue;
                
                if(hashmap.containsKey(discount[j])) {
                    count[hashmap.get(discount[j])]++;
                }
            }
            
            // 10일 동안 원하는 제품을 다 살 수 있는지 체크
            boolean canJoin = true;
            for(int j=0; j<number.length; j++) {
                if(count[j] != number[j]) {
                    canJoin = false;
                    break;
                }
            }
            
            answer += (canJoin)? 1 : 0;
        }
        
        
        return answer;
    }
}