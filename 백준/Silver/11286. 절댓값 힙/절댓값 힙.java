import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 절대값 힙 구현
		PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> {
			if (Math.abs(a) == Math.abs(b)) {
				// 오름차순
				return a - b;
			}
			// 절대값 오름차순
			return Math.abs(a) - Math.abs(b);
		});

		// 연산의 개수
		int N = Integer.parseInt(br.readLine());

		while(N-- > 0) {
			int x = Integer.parseInt(br.readLine());

			if(x==0) {
				if(heap.isEmpty()) {
					bw.append("0\n");
				} else {
					bw.append(String.valueOf(heap.poll())).append("\n");
				}
			} else {
				heap.add(x);
			}
		}

		bw.close();
		br.close();
	}

}