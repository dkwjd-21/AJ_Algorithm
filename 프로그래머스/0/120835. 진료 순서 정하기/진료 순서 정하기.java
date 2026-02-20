import java.util.Arrays;

class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        
        // 원본 배열을 유지하면서 배열 복사, 오름차순 정렬 
        int[] sorted = emergency.clone();
        Arrays.sort(sorted);
        
        for(int i=0; i<emergency.length; i++) {
            int tmp = emergency[i];
            int idx = -1;
            
            for(int j=0; j<sorted.length; j++) {
                if(sorted[j] == tmp) {
                    idx = j;
                    break;
                }
            }
            
            // sorted는 오름차순이므로, 역순으로 출력하기 위해 배열 전체길이에서 인덱스 값을 빼야함
            answer[i] = emergency.length - idx;
        }
        
        return answer;
    }
}