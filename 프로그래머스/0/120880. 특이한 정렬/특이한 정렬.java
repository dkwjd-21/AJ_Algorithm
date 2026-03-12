import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        // 원본 numlist와 n과의 거리를 담을 이차원 배열
        int len = numlist.length;
        int[][] temp = new int[len][2];
        
        for(int i=0; i<numlist.length; i++) {
            temp[i][0] = numlist[i];
            temp[i][1] = Math.abs(numlist[i] - n);
        }
        
        Arrays.sort(temp, (a, b) -> {
            if(a[1] == b[1]) {
                // 거리가 같으면 더 큰 수를 앞에 배치
                return b[0] - a[0];
            } else {
                // 거리가 가까운 순 = 오름차순으로 정렬 
                return a[1] - b[1];
            }
        });
        
        int[] answer = new int[len];
        
        for(int i=0; i<len; i++) {
            answer[i] = temp[i][0];
        }
        
        return answer;
    }
}