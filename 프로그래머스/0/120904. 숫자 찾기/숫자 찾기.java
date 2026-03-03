class Solution {
    public int solution(int num, int k) {
        int answer = 0;
        
        String[] numStr = (num + "").split("");
        for(int i=0; i<numStr.length; i++) {
            if(Integer.parseInt(numStr[i]) == k) {
                answer = i+1;
                break;
            }
        }
                
        return (answer==0)? -1 : answer;
    }
}