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

		// 큐스택을 구성하는 자료구조의 개수 N 
		int N = Integer.parseInt(br.readLine());
		
		// 큐스택의 결과값을 계산하기 위한 덱 
		Deque<Integer> deque = new ArrayDeque<>();
		
		// 수열 A : N개의 자료구조 정보. 0이면 큐. 1이면 스택. 
		String[] A = br.readLine().split(" ");
		
		// 수열 B : 초기값 
		String[] B = br.readLine().split(" ");
		
		// 덱에 초기값 입력
		for(int i=0; i<N; i++) {
			// 큐인 경우에만 값을 저장한다. 
			// 스택은 삽입한 값을 그대로 pop 하기 때문에 결과값에 영향을 미치지 못한다. 
			if(Integer.parseInt(A[i]) == 0) {
				deque.add(Integer.parseInt(B[i]));
			}
		}
		
		// 삽입할 수열의 길이 M 
		int M = Integer.parseInt(br.readLine());
		
		// 큐스택에 삽입할 길이 M의 수열 C 
		String[] C = br.readLine().split(" ");
		
		// M만큼 반복 
		for(int i=0; i<M; i++) {
			// 추가할 원소 Ci
			int c = Integer.parseInt(C[i]);
			
			// 원소는 맨 앞에 추가하고 맨 뒤의 요소를 pop(pollLast) 한다. 
			// 덱에 들어있는 요소가 점점 뒤로 밀려나는 구조이다. 
			deque.addFirst(c);
			bw.append(deque.pollLast()+" ");
		}
		
		bw.close();
		br.close();
	}
}