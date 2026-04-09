import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] network;
	static boolean[] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 정점의 개수 N, 간선의 개수 M, 탐색을 시작할 정점의 번호 V
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		network = new int[N+1][N+1];
		visited = new boolean[N+1];

		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			network[a][b] = network[b][a] = 1;
		}

		DFS(V, bw);
		bw.append("\n");

		Arrays.fill(visited, false);

		BFS(V, bw);

		bw.close();
		br.close();
	}

	// DFS (깊이 우선 탐색)
	static void DFS(int V, BufferedWriter bw) throws IOException {
		visited[V] = true;
		bw.append(String.valueOf(V)).append(" ");

		for(int i=1; i<N+1; i++) {
			if(network[V][i] == 1 && !visited[i]) {
				DFS(i, bw);
			}
		}
	}

	// BFS (너비 우선 탐색)
	static void BFS(int V, BufferedWriter bw) throws IOException {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(V);
		visited[V] = true;

		while(!queue.isEmpty()) {
			int curr = queue.poll();
			bw.append(String.valueOf(curr)).append(" ");

			for(int i=1; i<N+1; i++) {
				if(network[curr][i] == 1 && !visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}

	}

	/**
	 * [DFS: Depth-First Search (깊이 우선 탐색)]
	 * - 전략: 현재 경로를 끝까지 탐색한 후 다음 경로로 이동 ("한 우물만 파기")
	 * - 구현: 재귀 함수(Recursion) 또는 스택(Stack) 활용
	 * - 특징: 모든 노드 방문 시 유리, 경로의 제약 조건이 있을 때 적합
	 *
	 * [BFS: Breadth-First Search (너비 우선 탐색)]
	 * - 전략: 시작점에서 가까운 노드부터 순차적으로 탐색 ("파동처럼 퍼지기")
	 * - 구현: 큐(Queue) 자료구조 활용 (FIFO)
	 * - 특징: 최단 거리(Shortest Path) 보장, 최소 단계 탐색에 적합
	 */
}