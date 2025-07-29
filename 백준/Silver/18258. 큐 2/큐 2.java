import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 명령의 수 N
		int N = Integer.parseInt(br.readLine());

		// 큐
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			// 명령
			String[] command = br.readLine().split(" ");

			switch (command[0]) {
			// 정수 X를 큐에 넣는 연산이다.
			case "push":
				int X = Integer.parseInt(command[1]);
				queue.offer(X);
				break;
			// 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다.
			// 만약 큐에 정수가 없는 경우에는 -1을 출력한다.
			case "pop":
				if (queue.isEmpty()) {
					bw.append("-1\n");
				} else {
					bw.append(queue.poll()+"\n");
				}
				break;
			// 큐에 들어있는 정수의 개수를 출력한다.
			case "size":
				bw.append(queue.size()+"\n");
				break;
			// 큐가 비어있으면 1, 아니면 0을 출력한다.
			case "empty":
				bw.append((queue.isEmpty())? "1\n":"0\n");
				break;
			// 큐의 가장 앞에 있는 정수를 출력한다.
			// 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
			case "front":
				if(queue.isEmpty()) {
					bw.append("-1\n");
				} else {
					bw.append(queue.peek()+"\n");
				}
				break;
			// 큐의 가장 뒤에 있는 정수를 출력한다.
			// 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다
			case "back":
				if(queue.isEmpty()) {
					bw.append("-1\n");
				} else {
					bw.append(((LinkedList<Integer>)queue).peekLast()+"\n");
				}
				break;
			}
		}
		
		bw.close();
		br.close();
	}
}