import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 백준, 프로그래머스 제출 전 연습코드를 작성하는 클래스
public class Main {
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 연산의 개수 N
		int N = Integer.parseInt(br.readLine());
		// 기본 값 = 최소 힙
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		while (N-- > 0) {
			int x = Integer.parseInt(br.readLine());

			if(x == 0) {
				if(minHeap.isEmpty()) {
					bw.append("0").append("\n");
				} else {
					bw.append(String.valueOf(minHeap.poll())).append("\n");
				}
			} else {
				minHeap.add(x);
			}
		}

		bw.close();
		br.close();
	}
}