class Solution {
    public String solution(String rsp) {
        // 가위 2, 바위 0, 보 5
        String[] new_rsp = rsp.split("");
        StringBuilder answer = new StringBuilder();
        
        for(String tmp : new_rsp) {
            if(tmp.equals("2")) {
                answer.append("0");
            } else if(tmp.equals("0")) {
                answer.append("5");
            } else {
                answer.append("2");
            }
        }
        
        return answer.toString();
    }
}