import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 캠퍼스의 크기 N(세로) * M(가로)
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 캠퍼스 배열
		int[][] campus = new int[N][M];
		// 도연이 초기 위치
		int startX = 0; int startY = 0;

		for(int i=0; i<N; i++) {
			String[] tmp = br.readLine().split("");

			for(int j=0; j<M; j++) {
				String curr = tmp[j];

				if(curr.equals("P")) {
					// 사람이 있는 경우
					campus[i][j] = 1;
				} else if(curr.equals("X")) {
					// 벽인 경우
					campus[i][j] = -1;
				} else if(curr.equals("I")) {
					// 도연이 위치
					startX = i;
					startY = j;
				}
			}
		}

		boolean[][] visited = new boolean[N][M];
		campusTour(startX, startY, campus, visited);

		bw.append((cnt==0)? "TT" : String.valueOf(cnt));

		bw.close();
		br.close();
	}

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int cnt = 0;

	// (x, y)에서 상하좌우 이동 시작
	static public void campusTour(int x, int y, int[][] campus, boolean[][] visited) {
		visited[x][y] = true;
		if(campus[x][y] == 1) {
			cnt++;
		}

		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(nx >= 0 && nx < campus.length && ny >= 0 && ny < campus[0].length) {
				if(campus[nx][ny] != -1 && !visited[nx][ny]) {
					// 새로 가려는 곳이 벽이 아닌 경우
					campusTour(nx, ny, campus, visited);
				}
			}

		}
	}
}