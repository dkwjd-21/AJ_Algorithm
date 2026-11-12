class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right-left + 1)];
        
        // 2차원 배열 
        // ex) (0,0) -> 1
        //     (1,1) -> 2
        //     (2,2) -> 3
        // 두 인덱스 중 큰 값 + 1을 가지게 됨
        for (long i = left; i <= right; i++) {
            // 1차원 배열의 i번째 요소는 2차원 배열에서 몇 번째 요소? 
            long row = i / n;       // 행
            long col = i % n;       // 열 
            
            long max = Math.max(row, col);
            answer[(int) (i-left)] = (int) (max + 1);
            
        }
        
        
        return answer;
    }
}