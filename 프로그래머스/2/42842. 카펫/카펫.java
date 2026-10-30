class Solution {
    public int[] solution(int brown, int yellow) {
        // 카펫의 가로, 세로 크기를 return
        int[] answer = new int[2];
        
        // 노란색의 가로(j), 세로(i) 구하기  
        // *가로 길이 >= 세로 길이
        for(int i=1; i*i<=yellow; i++) {
            int j;
            
            if(yellow%i == 0) {
                j = yellow / i;
                
                // 카펫의 가로(x), 세로(y) 길이
                int x = j + 2;
                int y = i + 2;
                if(x*y - yellow == brown) {
                    answer[0] = x;
                    answer[1] = y;
                    break;
                }
            }
        }
        
        return answer;
    }
}