import java.io.*;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Stack<Integer> stack = new Stack<>();
		int lastVal = 1;	// stack에 푸쉬된 값들 중 최대값

		for(int num : arr) {
			while(lastVal <= num) {
				stack.push(lastVal++);
				sb.append("+\n");
			}

			// 최상위 값이 타깃과 같으면 팝
			if(stack.peek() == num) {
				stack.pop();
				sb.append("-\n");
			} else {
				sb.setLength(0);
				sb.append("NO");
				break;
			}
		}

		System.out.println(sb);
		br.close();
	}
}