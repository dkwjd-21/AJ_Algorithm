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
		
		// 스택 : 후입선출[LIFO]
		// 나중에 들어온 데이터가 먼저 빠져나간다.
		// push() 반환+추가, add() 추가(boolean)
		// pop() 반환+제거, peek() 반환
		
		Stack<Integer> stackInt = new Stack<>();
		
		// 명령의 수 N
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			String command[] = br.readLine().split(" ");
			
			switch (command[0]) {
			case "1":
				// 정수 X를 스택에 넣는다. 
				int X = Integer.parseInt(command[1]);
				stackInt.push(X);
				break;
			case "2":
				// 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다.
				// 없다면 -1을 대신 출력한다.
				if(stackInt.isEmpty()) {
					bw.append("-1\n");
				} else {
					bw.append(stackInt.pop()+"\n");
				}
				break;
			case "3":
				// 스택에 들어있는 정수의 개수를 출력한다.
				bw.append(stackInt.size()+"\n");
				break;
			case "4":
				// 스택이 비어있으면 1, 아니면 0을 출력한다.
				bw.append((stackInt.isEmpty())? "1\n":"0\n");
				break;
			case "5":
				// 스택에 정수가 있다면 맨 위의 정수를 출력한다.
				// 없다면 -1을 대신 출력한다.
				if(stackInt.isEmpty()) {
					bw.append("-1\n");
				} else {
					bw.append(stackInt.peek()+"\n");
				}
				break;
			default:
				break;
			}
		}
		
		
		bw.close();
		br.close();
	}
}