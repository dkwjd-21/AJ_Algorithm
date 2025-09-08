import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	// 9*9 스도쿠 판
	static int[][] sudoku = new int[9][9];

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 스도쿠 판 입력
		for (int i = 0; i < 9; i++) {
			String input[] = br.readLine().split(" ");
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = Integer.parseInt(input[j]);
			}
		}

		// 스도쿠 판 채우기 & 출력
		solveSudoku();
		
		br.close();
	}

	// 스도쿠 판 풀기
	public static void solveSudoku() throws IOException {
		// 스도쿠 판의 빈칸(값이 0인 곳)을 찾는다 (row, col)
		int row = 0, col = 0;
		// 스도쿠가 완성되었는가? 
		boolean isCompleted = true;

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (sudoku[i][j] == 0) {
					row = i;
					col = j;
					// 빈칸이 있음 -> 스도쿠 완성X
					isCompleted = false;

					// 빈칸을 찾았으면 j 반복문 종료
					break;
				}
			}
			if (!isCompleted) {
				// i 반복문 종료
				break;
			}
		}

		// 빈 칸이 더 이상 없으면 스도쿠 완성!
		if (isCompleted) {
			// 스도쿠 출력
			printSudoku();

			// 정답을 찾았으므로 시스템 종료!
			System.exit(0);
		}

		// 빈 칸에 1부터 9까지 숫자 시도
		for (int num = 1; num <= 9; num++) {
			// (row, col)에 num을 넣어도 되는지 검사
			if (canFill(row, col, num)) {
				// (row, col)에 num을 넣는다. 
				sudoku[row][col] = num;
				solveSudoku();
				// 백트래킹 : 원래 상태로 되돌린다. 
				sudoku[row][col] = 0;
			}
		}

	}

	// (row, col)에 num을 넣어도 되는지 검사하는 함수
	public static boolean canFill(int row, int col, int num) {

		// 같은 행에 동일한 값이 있는지 검사
		for (int i = 0; i < 9; i++) {
			if (sudoku[row][i] == num) {
				return false;
			}
		}

		// 같은 열에 동일한 값이 있는지 검사
		for (int i = 0; i < 9; i++) {
			if (sudoku[i][col] == num) {
				return false;
			}
		}

		// 3*3 안에 동일한 값이 있는지 검사
		int start_r = (row / 3) * 3;
		int start_c = (col / 3) * 3;

		for (int i = start_r; i < start_r + 3; i++) {
			for (int j = start_c; j < start_c + 3; j++) {
				if (sudoku[i][j] == num) {
					return false;
				}
			}
		}

		// 모든 검사 통과! -> num을 채울 수 있음.
		return true;
	}

	// 스도쿠 판 출력 함수
	public static void printSudoku() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 스도쿠 판 출력
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				bw.append(sudoku[i][j] + " ");
			}
			bw.append("\n");
		}

		bw.close();
	}
}