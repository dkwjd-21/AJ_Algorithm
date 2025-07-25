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

		// 명령의 수 N 
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<N; i++) {
			String[] command = br.readLine().split(" ");
			
			switch (command[0]) {
			case "push":
				int X = Integer.parseInt(command[1]);
				stack.push(X);
				break;
			case "pop":
				if(stack.empty()) {
					bw.append("-1\n");
				} else {
					bw.append(stack.pop()+"\n");
				}
				break;
			case "size":
				bw.append(stack.size()+"\n");
				break;
			case "empty":
				bw.append((stack.empty())? "1\n":"0\n");
				break;
			case "top":
				if(stack.empty()) {
					bw.append("-1\n");
				} else {
					bw.append(stack.peek()+"\n");
				}
				break;
			}
		}

		bw.close();
		br.close();
	}
}