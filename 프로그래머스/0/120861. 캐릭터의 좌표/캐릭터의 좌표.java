class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        // keyinput : 머쓱이가 입력한 방향키의 배열
        // board : 맵의 크기 
        // 키 입력이 모두 끝난 뒤에 캐릭터의 좌표를 리턴 {x, y}
        int[] answer = new int[] {0, 0};
        int width = board[0] / 2;   
        int height = board[1] / 2;
        
        for(int i=0; i<keyinput.length; i++) {
            switch(keyinput[i]) {
                case "up":      // y
                    if(answer[1] < height) answer[1]++; 
                    break;
                case "down":    // y
                    if(answer[1] > -1 * height) answer[1]--; 
                    break;
                case "left":    // x
                    if(answer[0] > -1 * width) answer[0]--; 
                    break;
                case "right":   // x
                    if(answer[0] < width) answer[0]++; 
                    break;
            }
        }
        
        return answer;
    }
}