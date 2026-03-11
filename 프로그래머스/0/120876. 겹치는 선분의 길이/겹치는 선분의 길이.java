class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        // 좌표의 범위 -100 <= 좌표 <= 100 에서 100을 더한 값으로 int 배열 생성
        // 점과 점 사이 '칸'을 지나는 선분의 값을 의미함 
        int[] numberLine = new int[201];
        
        for(int i=0; i<lines.length; i++) {
            for(int j=lines[i][0]; j<lines[i][1]; j++) {
                numberLine[j+100]++;   
            }
        }
        
        for(int number : numberLine) {
            if(number > 1) answer++;
        }
        
        return answer;
    }
}