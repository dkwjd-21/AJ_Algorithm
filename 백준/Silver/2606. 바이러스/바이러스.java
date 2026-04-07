import java.io.*;
import java.util.*;

// 백준, 프로그래머스 제출 전 연습코드를 작성하는 클래스
public class Main {
	static int N;
	static int[][] network;
	static boolean[] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 컴퓨터의 개수
		N = Integer.parseInt(br.readLine());
		// 직접 연결되어 있는 컴퓨터 쌍의 수
		int M = Integer.parseInt(br.readLine());

		// 연결 정보와 1번과 연결여부 체크 배열
		network = new int[N+1][N+1];
		visited = new boolean[N+1];			// 방문여부 배열

		while(M-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			network[a][b] = network[b][a] = 1;
		}

		// 1번 컴퓨터부터 바이러스 전파 시작
		dfs(1);

		// 바이러스가 전파된 컴퓨터의 개수 카운트
		int cnt = 0;
		for(int i=2; i<N+1; i++) {
			if(visited[i]) {
				cnt++;
			}
		}

		bw.append(String.valueOf(cnt));
        
		bw.close();
		br.close();
	}

	// DFS 깊이 우선 탐색
	static public void dfs(int curr) {
		visited[curr] = true;

		for(int i=1; i<N+1; i++) {
			if(network[curr][i] == 1 && !visited[i]) {
				// curr과 연결되어 있고, 아직 방문하지 않은 컴퓨터라면 -> 바이러스 전파
				dfs(i);
			}
		}
	}
}