import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 최대 힙
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

		// 연산의 개수 N
		int N = Integer.parseInt(br.readLine());

		while (N-- > 0) {
			int x = Integer.parseInt(br.readLine());

			if(x == 0) {
				if(maxHeap.isEmpty()) {
					bw.append("0\n");
				} else {
					bw.append(String.valueOf(maxHeap.poll())).append("\n");
				}
			} else {
				maxHeap.add(x);
			}
		}

		bw.close();
		br.close();
	}

}