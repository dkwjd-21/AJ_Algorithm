class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        String[] strArr = my_string.split(" ");
        String oper = "";
        answer = Integer.parseInt(strArr[0]);
        
        for(int i=1; i<strArr.length; i++) {
            if(i%2 == 1) {
                oper = strArr[i];
            } else {
                if(oper.equals("+")) {
                    answer += Integer.parseInt(strArr[i]);
                } else {
                    answer -= Integer.parseInt(strArr[i]);
                }
            }
        }
        
        return answer;
    }
}