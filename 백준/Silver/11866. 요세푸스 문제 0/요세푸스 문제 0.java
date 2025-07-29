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
		
		// N과 K가 주어진다. 
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		// N명의 원 (큐로 구현)
		Queue<Integer> queue = new LinkedList<>();
		
		// 큐 초기값 
		for(int i=1; i<=N; i++) {
			queue.add(i);
		}
		
		
		int cnt = 1;	// K번째 수인지 확인할 변수
		String res = "<";
		
		// queue가 전부 빌 때까지 K번째 빼는걸 반복. 
		while(!queue.isEmpty()) {
			if(queue.size()==1) {
				// 1개 남았을 때 
				res += queue.poll()+">";
			} else if(cnt%K == 0) {
				// K번째 수인 경우 뺀다.
				res += queue.poll()+", ";
			} else {
				// 빼야하는 수가 아닌 경우 
				queue.add(queue.poll());
			}
			cnt++;
		}
		
		bw.append(res);
		bw.close();
		br.close();
	}
}