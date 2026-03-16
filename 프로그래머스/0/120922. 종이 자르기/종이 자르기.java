class Solution {
    public int solution(int M, int N) {
        // M*N 크기의 종이를 최소로 가위질 해야하는 횟수 리턴
        int answer = 0;
        
        answer = scissors(M, N);
        
        return answer;
    }
    
    // X * Y 종이를 1*1 조각으로 자르는 메소드 
    public int scissors(int X, int Y) {
        // 1*1이 되었을때 재귀 종료 
        if(X == 1 && Y == 1) {
            return 0; 
        }
         
        if(X > 1) {
            // 가로로 자름 
            // 1번 가위질 + 왼쪽 조각 횟수 + 오른쪽 조각 횟수
            return 1 + scissors(X/2, Y) + scissors(X - X/2, Y);
        } else {
            // 세로로 자름
            // 1번 가위질 + 위쪽 조각 횟수 + 아래쪽 조각 횟수
            return 1 + scissors(X, Y/2) + scissors(X, Y - Y/2);
        }
    }
}