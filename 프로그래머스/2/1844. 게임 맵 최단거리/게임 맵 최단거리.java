import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        
        // 지도 n(세로) & m(가로)
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> queue = new LinkedList<>();

        // 1. 시작점 넣기
        int[] current = {0, 0};
        queue.add(current);

        // 거리 이동값 (동, 서, 남, 북)
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        // 2. Queue가 빌 때까지 반복
        while(!queue.isEmpty()) {

            // 3. 현재 좌표 꺼내기
            current = queue.poll(); 

            // 4. 네 방향 탐색
            for(int i = 0; i < 4; i++) {
                // 5. 다음 좌표 계산
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                
                // 6. 이동 가능한지 확인
                if(nx >= 0 && nx < n && ny >=0 && ny < m) {
                    // maps 범위 안이고, 벽이 아닌지
                    if(maps[nx][ny] == 1) {
                        // 7. 거리 갱신하고 Queue에 넣기
                        // 거리 갱신 : 이전 칸까지 이동한 횟수 + 1
                        maps[nx][ny] = maps[current[0]][current[1]] + 1;
                        
                        int[] next = {nx, ny};
                        queue.add(next);
                    }
                }
            }
        }
            
        if(maps[n-1][m-1] == 1) {
            return -1;
        }
        
        answer = maps[n-1][m-1];
        
        return answer;
    }
}