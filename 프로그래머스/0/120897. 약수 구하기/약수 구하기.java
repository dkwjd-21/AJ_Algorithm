import java.util.*;

class Solution {
    public int[] solution(int n) {
        // n의 약수를 오름차순으로 담은 배열을 리턴 
        int[] answer;
        StringBuilder sb = new StringBuilder();
        
        if(n != 1) {
            sb.append(1 + " " + n);
        } else {
            answer = new int[]{1};
            return answer;
        }
        
        
        for(int i=2; i*i<=n; i++) {
            if(n%i == 0) {
                if(i*i == n) {
                    sb.append(" " + i);
                } else {
                     sb.append(" " + i + " " + (n/i));
                }
            }
        }
        
        String str[] = sb.toString().split(" ");
        answer = new int[str.length];
        
        for(int i=0; i<str.length; i++) {
            answer[i] = Integer.parseInt(str[i]);
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}