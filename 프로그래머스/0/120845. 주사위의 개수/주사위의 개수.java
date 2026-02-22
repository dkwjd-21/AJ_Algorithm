class Solution {
    public int solution(int[] box, int n) {
        // box : 상자의 가로, 세로, 높이가 저장되어 있는 배열 
        // n : 주사위 모서리의 길이 
        // 상자에 들어갈 수 있는 주사위의 최대 개수 리턴 
        int answer = 0;
        
        answer = (box[0]/n) * (box[1]/n) * (box[2]/n);
        
        return answer;
    }
}