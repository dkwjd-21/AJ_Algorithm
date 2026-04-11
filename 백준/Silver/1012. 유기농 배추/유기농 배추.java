import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 테스트 케이스의 개수 T
		int T = Integer.parseInt(br.readLine());

		while(T-- > 0) {
			// 배추밭의 가로 길이 M, 세로 길이 N, 배추가 심어진 개수 K
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			// 배추가 심어진 지도
			int[][] map = new int[N][M];
			// 해당 위치 방문여부
			boolean[][] visited = new boolean[N][M];

			while(K-- > 0) {
				// 배추가 심어진 위치 (x,y) --> 배열에서는 x, y 반대임에 주의
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				map[y][x] = 1;
			}

			int cnt = earthwarmCnt(map, visited);
			bw.append(String.valueOf(cnt)).append("\n");
		}

		bw.close();
		br.close();
	}

	static public int earthwarmCnt(int[][] map, boolean[][] visited) {
		int count = 0;

		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				// (j, i) 위치에 배추가 심어져 있는 경우 && 방문하지 않은 경우
				if(map[i][j] == 1 && !visited[i][j]) {
					count++;
					dfs(i, j, map, visited);
				}
			}
		}

		return count;
	}

	// 좌표값에서 상하좌우 이동을 위한 배열
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {-1, 1, 0, 0};

	// (x, y)에서 인접하는 배추 모두 방문으로 바꾸는 메서드 - 깊이우선탐색
	static public void dfs(int y, int x, int[][] map, boolean[][] visited) {
		visited[y][x] = true;

		for(int i=0; i<4; i++) {
			int newY = y + dy[i];
			int newX = x + dx[i];

			if(newX >= 0 && newX <map[0].length && newY >=0 && newY <map.length) {
				if(map[newY][newX] == 1 && !visited[newY][newX]) {
					dfs(newY, newX, map, visited);
				}
			}
		}
	}
}