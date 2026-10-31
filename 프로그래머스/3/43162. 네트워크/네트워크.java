class Solution {
    // 컴퓨터 체크 여부
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        // n : 컴퓨터의 개수
        // computers : 연결에 대한 정보가 담긴 배열
        //             i번과 j번 컴퓨터가 연결되어 있으면 1로 표현 
        // 네트워크 개수를 return
        int answer = 0;
        visited = new boolean[n];
        
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                answer++;
                chkNetwork(i, n, computers);
            }
        }
        
        return answer;
    }
    
    // 네트워크 체크 (시작 번호, n, 연결정보)
    public void chkNetwork(int idx, int n, int[][] computers) {
        visited[idx] = true;
        
        // idx와 연결된 컴퓨터를 visited true 처리 
        for(int i=0; i<n; i++) {
            if(computers[idx][i] == 1 && !visited[i]) {
                chkNetwork(i, n, computers);
            }
        }
        
    }
    
}