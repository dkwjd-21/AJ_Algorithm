import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 아파트는 최대 14층, 최대 14호까지 있음 (0층포함)
		int[][] apt = new int[15][15];
		// 0층 i호 초기화
		for(int i=1; i<15; i++) {
			apt[0][i] = i;
		}
		// 모든 층의 1호는 1명이 살고있음
		for(int i=1; i<15; i++) {
			apt[i][1] = 1;
		}

		// 나머지 층 계산 (1층부터)
		for(int i=1; i<15; i++) {
			for(int j=2; j<15; j++) {
				// i층 j호에 사는 사람 수 = i층 j-1호 사람 수 + i-1층 j호 사람 수
				apt[i][j] = apt[i][j-1] + apt[i-1][j];
			}
		}


		// 테스트 케이스 T
		int T = Integer.parseInt(br.readLine());

		for(int i=0; i<T; i++) {
			// 정수 k, n
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());

			// k층 n호에 몇 명이 살고 있는지 출력
			System.out.println(apt[k][n]);
		}

		br.close();
	}
}

/*
  k층 n호에 사는 사람 수 = k층 n-1호 사람 수 + k-1층 n호 사람 수
  1층 -> 1명 3명 6명 10 15명 21 28 36 45 55명 66명 78명 91명 105명
* 0층 -> 1명 2명 3명 4명 5명 6명 7명 8명 9명 10명 11명 12명 13명 14명
* */