class Solution {
    public int solution(int n, int[][] wires) {
        // n : 송전탑의 개수 
        // wires : 전선 정보 
        // 두 전력망이 가지고 있는 송전탑 개수의 차이 return 
        int answer = Integer.MAX_VALUE;
        
        // 전선 정보 2차원 배열로 변환
        boolean[][] connect = new boolean[n+1][n+1];
        
        for(int i=0; i<n-1; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            connect[v1][v2] = true;
            connect[v2][v1] = true;
        }
        
        for(int i=0; i<n-1; i++) {
            // 1개씩 연결 끊어보기 
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            connect[v1][v2] = false;
            connect[v2][v1] = false;
            
            boolean[] visited = new boolean[n+1];
            // 1번과 연결된 송전탑 개수 체크
            int count = bfs(1, connect, visited);
            // 1번과 연결되지 않은 송전탑 개수 
            int other = n - count;
            
            answer = Math.min(answer, Math.abs(count-other));
            
            // 연결 되돌리기
            connect[v1][v2] = true;
            connect[v2][v1] = true;
            
        }
        
        
        return answer;
    }
    
    // num번과 연결된 송전탑 체크 
    public int bfs(int num, boolean[][] connect, boolean[] visited) {
        visited[num] = true;
        
        int count = 1;
        
        for(int i=0; i<connect.length; i++) {
            if(connect[num][i] && !visited[i]) {
                count += bfs(i, connect, visited);
            }
        }
        
        return count;
    }
}