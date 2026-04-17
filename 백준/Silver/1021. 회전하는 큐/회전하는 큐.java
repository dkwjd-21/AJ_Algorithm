import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 큐의 크기 N, 뽑아낼 숫자의 개수 M
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 양방향 순환 큐 (디큐)
		LinkedList<Integer> deque = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			deque.add(i);
		}

		// 뽑아낼 수 (타깃 인덱스)
		st = new StringTokenizer(br.readLine());
		int[] targets = new int[M];
		for(int i=0; i<M; i++) {
			targets[i] = Integer.parseInt(st.nextToken());
		}

		// 2번, 3번 연산의 최솟값
		int cnt = 0;

		for(int target : targets) {
			int targetIdx = deque.indexOf(target);
			int halfIdx;

			// 중간 지점 계산
			if(deque.size() % 2 == 0) {
				halfIdx = deque.size() / 2 - 1;
			} else {
				halfIdx = deque.size() / 2;
			}

			// 타깃 인덱스가 중간 지점 전인지 후인지 구분하여 2or3번 로직 진행
			if(targetIdx <= halfIdx) {
				// 타깃 인덱스가 중간 지점 전 => 앞에서부터 타깃이 나올 때까지 순환 (왼쪽으로 돌리기)
				for(int j=0; j<targetIdx; j++) {
					deque.addLast(deque.pollFirst());
					cnt++;
				}
			} else {
				// 타깃 인덱스가 중간 지점 후 => 뒤에서부터 타깃이 맨 앞으로 갈 때까지 순환 (오른쪽으로 돌리기)
				for(int j=0; j<deque.size()-targetIdx; j++) {
					deque.addFirst(deque.pollLast());
					cnt++;
				}
			}

			// 타깃이 맨 위에 옴
			deque.pollFirst();
		}

		bw.append(String.valueOf(cnt));

		bw.close();
		br.close();
	}

}