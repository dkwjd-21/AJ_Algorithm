import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 명령의 수 N
		int N = Integer.parseInt(br.readLine());
		
		// 덱 
		Deque<Integer> deque = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			String[] command = br.readLine().split(" ");
			int X;
			
			switch (command[0]) {
			// 정수 X를 덱의 앞에 넣는다.
			case "1":
				X = Integer.parseInt(command[1]);
				deque.addFirst(X);
				break;
			// 정수 X를 덱의 뒤에 넣는다.
			case "2":
				X = Integer.parseInt(command[1]);
				deque.addLast(X);
				break;
			// 덱에 정수가 있다면 맨 앞의 정수를 빼고 출력한다.
			// 없다면 -1을 대신 출력한다.
			case "3":
				if(deque.isEmpty()) {
					bw.append("-1\n");
				} else {
					bw.append(deque.pollFirst()+"\n");
				}
				break;
			// 덱에 정수가 있다면 맨 뒤의 정수를 빼고 출력한다.
			// 없다면 -1을 대신 출력한다.
			case "4":
				if(deque.isEmpty()) {
					bw.append("-1\n");
				} else {
					bw.append(deque.pollLast()+"\n");
				}
				break;
			// 덱에 들어있는 정수의 개수를 출력한다.
			case "5":
				bw.append(deque.size()+"\n");
				break;
			// 덱이 비어있으면 1, 아니면 0을 출력한다.
			case "6":
				bw.append((deque.isEmpty())? "1\n":"0\n");
				break;
			// 덱에 정수가 있다면 맨 앞의 정수를 출력한다.
			// 없다면 -1을 대신 출력한다.
			case "7":
				if(deque.isEmpty()) {
					bw.append("-1\n");
				} else {
					bw.append(deque.peekFirst()+"\n");
				}
				break;
			// 덱에 정수가 있다면 맨 뒤의 정수를 출력한다.
			// 없다면 -1을 대신 출력한다.
			case "8":
				if(deque.isEmpty()) {
					bw.append("-1\n");
				} else {
					bw.append(deque.peekLast()+"\n");
				}
				break;
			}
		}

		bw.close();
		br.close();
	}
}