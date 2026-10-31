import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        
        int n = maps.length;
        int m = maps[0].length;
        
        // 이동 매트릭스 (동, 서, 남, 북)
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        // 방문 여부
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        
        Queue<int[]> queue = new LinkedList<>();
        
        int[] current = {0, 0};
        
        queue.add(current);
        
        while(!queue.isEmpty()) {
            
            current = queue.poll();
            
            // 동서남북 이동 
            for(int i=0; i<4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                
                // 이동할 칸이 maps 범위 안일 때만 이동가능
                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    // 방문하지않음 && 벽이 아님 
                    if(!visited[nx][ny] && maps[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        
                        maps[nx][ny] = maps[current[0]][current[1]] + 1;
                    
                        queue.add(new int[]{nx, ny});
                    }   
                }
            }
        }
        
        if(maps[n-1][m-1] == 1) {
            return -1;
        } else {
            answer = maps[n-1][m-1];
        }
        
        return answer;
    }
}