class Solution {
    // 컴퓨터 방문 여부 
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        // n : 컴퓨터의 개수
        // computers : 연결에 대한 정보가 담긴 배열
        //             i번과 j번 연결되어 있으면 1로 표현
        // 네트워크의 개수 return 
        int answer = 0;
        
        visited = new boolean[n];
        
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                answer++;
                chkNetwork(i, computers, n);
            }
        }
        
        return answer;
    }
    
    // num 컴퓨터와 연결된 네트워크 체크 (번호, 연결정보, 컴퓨터 수)
    public void chkNetwork(int num, int[][] computers, int n) {
        // num 방문처리
        visited[num] = true;
        
        for(int i=0; i<n; i++) {
            if(computers[num][i] == 1 && !visited[i]) {
                chkNetwork(i, computers, n);
            }
        }
    }
    
}