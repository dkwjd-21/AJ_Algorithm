import java.util.Stack;

class Solution {
		boolean solution(String s) {
			// ( 또는 ) 로만 이루어진 문자열 s 
			// 문자열 s가 올바른 괄호면 true, 아니면 false return 
			boolean answer = true;

			Stack<Character> parentheses = new Stack<Character>();
			
			for(int i=0; i<s.length(); i++) {
				char tmp = s.charAt(i);
				
				// 스택이 비어 있거나, 상위의 요소와 같은 경우 추가
				if(parentheses.isEmpty() || tmp==parentheses.peek()) {
					// 스택이 비어 있는데 )가 첫번째로 온다면 false 
					if(parentheses.isEmpty() && tmp == ')') {
						answer = false;
						return answer;
					}
					
					parentheses.add(tmp);
				}
				
				// 상위의 요소와 다른 경우, 추가하지 않고 상위 요소 삭제 
				if(tmp!=parentheses.peek()) {
					parentheses.pop();
				}
			}

			// 스택이 비어있다면 true, 아니면 false
			answer = (parentheses.isEmpty())? true : false;
			return answer;
		}
	}