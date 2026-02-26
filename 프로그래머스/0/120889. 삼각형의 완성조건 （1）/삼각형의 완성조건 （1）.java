import java.util.*;

class Solution {
    public int solution(int[] sides) {
        // 가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야 함
        // 삼각형을 만들 수 있다면 1, 만들 수 없다면 2 리턴
        int answer = 0;
        
        Arrays.sort(sides);
        
        if(sides[2] < sides[0] + sides[1]) {
            answer = 1;
        } else {
            answer = 2;
        }
        
        return answer;
    }
}