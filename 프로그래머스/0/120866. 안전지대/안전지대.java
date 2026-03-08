import java.util.*;

class Solution {
    boolean[][] isSafe;
    int n;
    
    public int solution(int[][] board) {
        int answer = 0;
        n = board.length;
        isSafe = new boolean[n][n];
        // 2차원 배열은 각 행마다 fill 해주어야 함
        for(int i=0; i<n; i++) {
            Arrays.fill(isSafe[i], true);
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 1) {
                    safeToUnsafe(i, j); 
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(isSafe[i][j]) answer++;
            }
        }
        
        return answer;
    }
    
    public void safeToUnsafe(int x, int y) {
        // 지뢰 주변의 isSafe 여부를 false로 바꾸는 메소드
        for(int i=x-1; i<=x+1; i++) {
            for(int j=y-1; j<=y+1; j++) {
                if(i>=0 && i<n && j>=0 && j<n) {
                    isSafe[i][j] = false;
                }
            }
        }
    }
}