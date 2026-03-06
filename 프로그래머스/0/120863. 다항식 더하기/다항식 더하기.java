class Solution {
    public String solution(String polynomial) {
        StringBuilder answer = new StringBuilder();
        // 더하기 기호와 공백을 제외한 항들을 배열로 분리
        String[] polyArr = polynomial.split(" \\+ ");  
        
        // 일차항, 상수항의 계수값 
        int lenear = 0, costant = 0;
        
        for(String tmp : polyArr) {            
            if(tmp.contains("x")) {
                String numStr = tmp.replace("x", "");
                if(numStr.isEmpty()) {
                    lenear += 1; 
                } else {
                    lenear += Integer.parseInt(numStr);
                }
            } else {
                costant += Integer.parseInt(tmp);
            }
        }
        
        if(lenear > 0) {
            answer.append((lenear == 1)? "x" : lenear+"x");
        }
        
        if(costant > 0) {
            if(answer.length() > 0) answer.append(" + ");
            answer.append(costant);
        }
        
        return answer.toString();
    }
}