import java.util.*;

class Solution {
    public int solution(int[] sides) {
        // 두 변의 길이가 담긴 배열 sides 
        int answer = 0;
        Arrays.sort(sides);
        
        // 1) 나머지 한 변이 가장 긴 변인 경우
        int sum = sides[0] + sides[1];
        for(int i=sides[1]+1; i<sum; i++) {
            answer++;
        }
        
        // 2) 주어진 두 변 중 더 긴 변이 가장 긴 변인 경우
        for(int i=1; i<=sides[1]; i++) {
            if(i + sides[0] > sides[1]) {
                answer++;
            }
        }
        
        return answer;
    }
}