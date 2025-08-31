import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	// N*N 체스판에 N개의 퀸을 서로 공격할 수 없도록 배치
	// -> 1. 같은 행(가로)에 두 개 이상의 퀸이 있으면 안됨
	// -> 2. 같은 열(세로)에 두 개 이상의 퀸이 있으면 안됨
	// -> 3. 같은 대각선에 두 개 이상의 퀸이 있으면 안됨
	static int N; // N
	static int cnt; // 경우의 수
	static boolean isQueen[][]; // N*N 체스판
	// -> true : 퀸이 있음
	// -> false : 퀸이 없음

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 첫째 줄에 N이 주어진다 (1<=N<=15)
		N = Integer.parseInt(br.readLine());

		// N*N 체스판 만들기 (초기값 : false)
		isQueen = new boolean[N][N];

		// 경우의 수 계산
		solve(0);

		// 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수 출력
		System.out.println(cnt);

		br.close();
	}

	// index번째 행(가로)에 퀸을 놓는다.
	static void solve(int index) {
		// index가 N과 같아지면, N개의 퀸을 모두 성공적으로 배치했다!
		if (index == N) {
			cnt++;
			return;
		}

		// 현재 행(index)에 모든 열을 대상으로 퀸을 놓을 수 있는지 확인
		for (int i = 0; i < N; i++) {
			// 퀸을 놓을 수 있는지 확인한다.
			if (!canAttack(index, i, isQueen)) {
				// 퀸을 놓는다.
				isQueen[index][i] = true;
				// 다음 행으로 넘어간다.
				solve(index + 1);
				// 백트래킹을 위해 리셋한다.
				isQueen[index][i] = false;
			}
		}
	}

	// (row, col)에 퀸을 놓았을 때, 공격 가능 여부를 확인
	static public boolean canAttack(int row, int col, boolean[][] board) {
		// 각 행에 1개씩 놓는다는 전제하에 확인하기 때문에 행은 확인X

		// 1. 같은 열에 퀸이 있는지 확인
		for (int i = 0; i < row; i++) {
			// 같은 열에 퀸이 있으면 false를 반환한다.
			if (board[i][col]) {
				return true;
			}
		}

		// 2. 좌상향 대각선에 퀸이 있는지 확인
		// 대각선은 열이 0보다 클 때만 확인 할 수 있다.
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			// 가장 아래 행에 놓을 위치를 기준으로 좌상향 -> i--, j--
			if (board[i][j]) {
				return true;
			}
		}

		// 3. 우상향 대각선에 퀸이 있는지 확인
		// 대각선은 열이 0보다 클 때만 확인 할 수 있다.
		for (int i = row - 1, j = col + 1; i >= 0 && j <N ; i--, j++) {
			// 가장 아래 행에 놓을 위치를 기준으로 우상향 -> i--, j++
			if (board[i][j]) {
				return true;
			}
		}

		// 퀸이 없다 -> 공격할 수 없다!
		return false;
	}
}