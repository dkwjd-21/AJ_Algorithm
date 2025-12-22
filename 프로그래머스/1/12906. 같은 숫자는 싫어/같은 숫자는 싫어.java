import java.util.*;

public class Solution {
		public int[] solution(int []arr) {
			// 0~9로 이루어진 배열 arr
			// 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거 
			
//			int[] answer = {};
        
			// arr 배열 -> 스택 사용 
			// 스택 : 선입후출 
			Stack<Integer> stack = new Stack<>();
        
			for(int num : arr) {
				if(stack.isEmpty() || stack.peek()!=num) {
					// 스택이 비어있거나, 맨 위의 것과 다른 경우에만 추가
					stack.push(num);
				}
			}
			
			int[] answer = new int[stack.size()];
			
			for(int i=stack.size()-1; i>=0; i--) {
				answer[i] = stack.pop();
			}
			
			return answer;
		}
	}