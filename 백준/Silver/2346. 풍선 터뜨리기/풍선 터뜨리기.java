import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 덱 
		Deque<int[]> deque = new ArrayDeque<>();
		
		// 자연수 N 
		int N = Integer.parseInt(br.readLine());
		
		// 풍선 안의 종이에 적혀 있는 수
		String[] input = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			int[] arr = {i+1, Integer.parseInt(input[i])};
			deque.add(arr);
		}
		
		// 1번 풍선을 터뜨리고 인덱스 출력. 
		int[] tmp = deque.pollFirst();
		String output = tmp[0]+" ";
		
		// tmp에 맞게 반복 실행 - 덱이 empty 될 때 까지
		while(!deque.isEmpty()) {
			if(tmp[1] > 0) {
				// tmp가 양수일 때, 앞에서부터 tmp번째인 풍선을 제거한다. 
				for(int i=1; i<tmp[1]; i++) {
					// tmp번째 앞에 있는 풍선은 뒤로 이동시킨다. 
					deque.addLast(deque.pollFirst()); 
				}
				// tmp번째 풍선을 터뜨린다.
				tmp = deque.pollFirst();
			} else if(tmp[1] < 0){
				// tmp가 음수일 때, 뒤에서부터 tmp번째인 풍선을 제거한다. 
				for(int i=1; i<tmp[1]*-1; i++) {
					// tmp번째 뒤에 있는 풍선은 앞으로 이동시킨다.
					deque.addFirst(deque.pollLast());
				}
				// tmp번째 풍선을 터뜨린다. 
				tmp = deque.pollLast();
			}
			// 터뜨린 풍선의 인덱스를 출력한다. 
			output += tmp[0]+" ";
		}
		
		// 마지막에 위치한 " " 제거 
		output = output.trim();
		bw.append(output);	
		
		bw.close();
		br.close();
	}
}