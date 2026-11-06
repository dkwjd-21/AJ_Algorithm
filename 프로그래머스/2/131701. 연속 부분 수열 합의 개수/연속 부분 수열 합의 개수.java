import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int length = elements.length;
        
        // 합을 중복없이 저장할 set
        HashSet<Integer> sumSet = new HashSet<Integer>();

        for(int i = 0; i < length; i++) {
            int sum = 0;

            for(int j = 0; j < length; j++) {
                sum += elements[(i + j) % length];
                sumSet.add(sum);
            }
        }
        
        answer = sumSet.size();
        
        return answer;
    }
}