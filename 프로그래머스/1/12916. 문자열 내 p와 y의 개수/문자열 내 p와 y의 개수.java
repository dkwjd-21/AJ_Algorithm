class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int cntP = 0;
        int cntY = 0;

        for(int i=0; i<s.length(); i++) {
            char tmp = s.charAt(i);
            
            if(tmp == 'p' || tmp == 'P') {
                cntP++;
            } else if(tmp == 'y' || tmp == 'Y') {
                cntY++;
            }
        }

        if(cntP == 0 && cntY == 0) {
            answer = true;
        } else {
            answer = (cntP == cntY);
        }
        
        return answer;
    }
}