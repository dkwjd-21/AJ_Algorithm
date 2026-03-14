import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        // 영어 점수와 수학 점수의 평균을 기준으로 매긴 등수 배열 
        int[] answer = new int[score.length];
        int sum[] = new int[score.length];
        
        for(int i=0; i<score.length; i++) {
            sum[i] = score[i][0] + score[i][1];
        }
        
        Arrays.sort(sum);
        
        for(int i=0; i<score.length; i++) {
            int curr = score[i][0] + score[i][1];
            int rank = 1;
            
            for(int j=sum.length-1; j>=0; j--) {
                if(sum[j] > curr) {
                    rank++;
                } else {
                    break;   
                }
            }
            
            answer[i] = rank;
        }
        
        return answer;
    }
}