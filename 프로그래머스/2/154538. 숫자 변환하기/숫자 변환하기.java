import java.util.*;
    
class Solution {
    public int solution(int x, int y, int n) {
        if(x == y) return 0;
        
        int[] visited = new int[y+1];
        Queue<Integer> queue = new LinkedList();
        queue.add(x);
        
        while(!queue.isEmpty()) {
            // 현재 큐에 있는 값을 가져옴 
            int curr = queue.poll();    
            
            // 큐에 있는 값으로 연산 1회
            int[] nextValue = {curr+n, curr*2, curr*3};
            visited[curr]++;
            
            for(int next : nextValue) {
                if(next <= y && visited[next] == 0) {
                    if(next == y) {
                        return visited[curr];
                    } else {
                        visited[next] = visited[curr];
                        queue.add(next);
                    }
                }
            }
        }
        
        // x로 y를 만들지 못함 
        return -1;
    }
}