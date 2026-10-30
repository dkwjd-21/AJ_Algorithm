class Solution {
    static int min = Integer.MAX_VALUE;
    // 던전 탐험 횟수
    static int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        // k : 유저의 현재 피로도
        // dungeons : 각 던전별 최소 필요 피로도, 소모 피로도 
        // 탐험할 수 있는 최대 던전 수 return
        
        // 던전 탐험 여부
        boolean[] isDone = new boolean[dungeons.length];
        for(int i=0; i<dungeons.length; i++) {
            min = Math.min(min, dungeons[i][0]);
        }
        
        adventure(k, dungeons, isDone, 0);
        
        
        return answer;
    }
    

    // 던전 탐험 시작 (현재 피로도, 던전배열, 탐험여부, 현재까지 탐험한 던전 수)  
    public void adventure(int k, int[][] dungeons, boolean[] isDone, int cnt) {
        if(k<min || cnt == dungeons.length) {
            // 더 이상 탐험하지 못하는 경우 
            // 현재 피로도가 '최소 필요 피로도'보다 작을 때
            // 모든 던전을 탐험했을 때
            answer = Math.max(answer, cnt);
        }
        
        for(int i=0; i<dungeons.length; i++) {
            // i번째 던전 확인
            if(!isDone[i] && k >= dungeons[i][0]) {
                isDone[i] = true;
                adventure(k-dungeons[i][1], dungeons, isDone, cnt+1);
                isDone[i] = false;
            }
        }
    }
    
}