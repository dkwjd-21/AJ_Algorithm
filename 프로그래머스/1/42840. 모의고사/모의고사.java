class Solution {
    public int[] solution(int[] answers) {
        // 1번 수포자 : 1, 2, 3, 4, 5, ...
        // 2번 수포자 : 2, 1, 2, 3, 2, 4, 2, 5, ...
        // 3번 수포자 : 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
        // answers : 1번 문제부터 마지막 문제까지의 정답이 든 배열 
        
        // 가장 많은 문제를 맞힌 사람의 점수 
        int max = 0; 
        // 가장 많은 문제를 맞힌 사람의 수
        int count = 0;
        
        int[] per1 = {1, 2, 3, 4, 5};
        int[] per2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] per3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];
        
        for(int i=0; i<answers.length; i++) {
            int n = answers[i];
            
            if(n == per1[i%5]) {
                score[0]++;
            }
            if(n == per2[i%8]) {
                score[1]++;
            }
            if(n == per3[i%10]) {
                score[2]++;
            }
            
            if(i == answers.length-1) {
                max = Math.max(Math.max(score[0], score[1]), score[2]);
            }
        }
        
        for(int i=0; i<score.length; i++) {
            if(max == score[i]) {
                count++;
            }
        }
        
        // 가장 많은 문제를 맞힌 사람이 누군인지 return
        int[] answer = new int[count];
        
        count = 0;
        
        for(int i=0; i<score.length; i++) {
            if(max == score[i]) {
                answer[count++] = i+1;
            }
        }
        
        return answer;
    }
}