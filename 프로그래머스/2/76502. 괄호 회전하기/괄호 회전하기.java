import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i=0; i<s.length(); i++) {
            // 0번째라면 그대로 진행
            if(i==0) {
                if(isRight(s)) answer++;
            } else {
                // 문자열을 밀기 시작
                s = s.substring(1, s.length()) + s.substring(0, 1);
                
                if(isRight(s)) answer++;
            }
            
        }
        
        return answer;
    }
    
    public boolean isRight(String str) {
        // str이 올바른 괄호 문자열인지 확인하는 메소드
        Stack<Character> stack = new Stack<Character>();
        
        for(int i=0; i<str.length(); i++) {
            char curr = str.charAt(i);
            
            // 여는 괄호라면 스택에 바로 추가
            if(curr == '(' || curr == '[' || curr == '{') {
                stack.push(curr);
            } else {
                if(stack.isEmpty()) {
                    return false;
                } else {
                    char top = stack.pop();
                    
                    if(curr == ')' && top != '(') return false;
                    if(curr == '}' && top != '{') return false;
                    if(curr == ']' && top != '[') return false;
                }
            }
            
        }
        
        return stack.isEmpty();
    }
}