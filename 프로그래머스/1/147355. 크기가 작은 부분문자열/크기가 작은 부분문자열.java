class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long intP = Long.parseLong(p);
        int length = p.length();
        
        // 1 <= p의 길이 <= t의 길이
        // t를 p 길이만큼 자른 부분의 수가 p보다 작거나 같은 횟수 return 
        for(int i=0; i<=t.length()-length; i++) {
            
            long tmp = Long.parseLong(t.substring(i, i+length));
            if(tmp <= intP) answer++;
        }
        
        return answer;
    }
}