import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스의 수
		int T = Integer.parseInt(br.readLine());

		for(int i=0; i<T; i++) {
			// 문서의 개수 N
			// 몇 번째로 인쇄되었는지 궁금한 문서가 현재 큐에서 몇 번째에 놓여 있는지 나타내는 정수 M
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);

			// N개 문서의 중요도 (1~9 이하 정수)
			// {중요도, 타깃여부(1,0)}
			Queue<int[]> queue = new LinkedList<>();
			input = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				if(j == M) {
					// 타깃 문서인 경우
					queue.add(new int[]{Integer.parseInt(input[j]), 1});
				} else {
					queue.add(new int[]{Integer.parseInt(input[j]), 0});
				}
			}

			// 몇 번째 인쇄물인지 카운트
			int cnt = 0;

			while(!queue.isEmpty()) {
				int[] curr = queue.poll();
				boolean canPrint = true;

				for(int[] tmp : queue) {
					// 현재문서보다 중요도가 높은 문서가 있는 경우
					if(curr[0] < tmp[0]) {
						canPrint = false;
					}
				}

				if(canPrint) {
					cnt++;

					if(curr[1] == 1) {
						System.out.println(cnt);
						break;
					}
				} else {
					queue.add(curr);
				}
			}

		}

		br.close();
	}
}