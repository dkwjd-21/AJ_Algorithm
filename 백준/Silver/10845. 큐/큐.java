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
			case "push":
				int X = Integer.parseInt(command[1]);
				queue.add(X);
				break;
			case "pop":
				if(queue.isEmpty()) {
					bw.append("-1\n");
				} else {
					bw.append(queue.remove()+"\n");
				}
				break;
			case "size":
				bw.append(queue.size()+"\n");
				break;
			case "empty":
				bw.append((queue.isEmpty())? "1\n":"0\n");
				break;
			case "front":
				if(queue.isEmpty()) {
					bw.append("-1\n");
				} else {
					bw.append(queue.peek()+"\n");
				}
				break;
			case "back":
				if(queue.isEmpty()) {
					bw.append("-1\n");
				} else {
					bw.append(queue.toArray()[queue.size()-1]+"\n");
				}
				break;
			}
		}

		bw.close();
		br.close();
	}
}