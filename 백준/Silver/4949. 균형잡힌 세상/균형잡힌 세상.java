import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while(true) {
			// 문자열 입력
			String input = br.readLine();
			
			// 온점 하나가 들어오면 종료
			if(input.equals(".")) break;
			
			// 결과값
			String result = isBalance(input);
			
			bw.append(result+"\n");
		}

		bw.close();
		br.close();
	}
	
	// 문자열이 균형을 이루고 있는지 확인하는 함수
	public static String isBalance(String input) {
		Stack<Character> stackChar = new Stack<>();
		
		for(int i=0; i<input.length(); i++) {
			char tmp = input.charAt(i);
			
			if(tmp == '(' || tmp == '[') {
				// 여는 괄호는 언제든지 추가할 수 있다. 
				stackChar.push(tmp);
			} else if(tmp == ')') {
				if(stackChar.isEmpty()) {
					// 스택이 비어있을 때는 추가할 수 없다.
					return "no";
				}
				
				if(stackChar.peek() == '(') {
					// 스택의 마지막 요소와 쌍을 이룰 때는 마지막 요소를 제거한다. 
					stackChar.pop();
				} else {
					// 쌍을 이루지 않을 때는 균형이 잡히지 않았다. 
					return "no";
				}
			} else if(tmp == ']') {
				if(stackChar.isEmpty()) {
					// 스택이 비어있을 때는 추가할 수 없다.
					return "no";
				}
				
				if(stackChar.peek() == '[') {
					// 스택의 마지막 요소와 쌍을 이룰 때는 마지막 요소를 제거한다. 
					stackChar.pop();
				} else {
					// 쌍을 이루지 않을 때는 균형이 잡히지 않았다. 
					return "no";
				}
			}
		}
		
		// 스택이 비어있으면 균형잡힌 문자열이다. 
		if(stackChar.isEmpty()) {
			return "yes";
		} else {
			return "no";
		}
	}
}