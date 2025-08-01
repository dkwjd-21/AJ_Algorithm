import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	// 메모이제이션을 사용하여 미리 조합의 값을 저장해둔다.
	// 메모이제이션 : 같은 입력이 반복될 때 저장한 값을 반환하도록 하여 속도를 높이는 최적화 기술
	// 0 <= n <= m <= 30
	static int[][] combi = new int[30][30];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 테스트 케이스의 개수 T
		int T = Integer.parseInt(br.readLine());
		
		String result = "";
		
		for (int i = 0; i < T; i++) {
			// 서쪽 사이트 N, 동쪽 사이트 M
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);

			result += combination(M, N)+"\n";
		}

		bw.append(result);
		bw.close();
		br.close();
	}

	// nCr
	public static int combination(int n, int r) {
		// 이미 계산한 값일 경우
		if (combi[n][r] > 0) {
			return combi[n][r];
		}
		
		// nCn, nC0 일 경우
		if(n==r || r==0) {
			return combi[n][r] = 1;
		}
		
		// nCr = n-1Cr-1 + n-1Cr
		return combi[n][r] = combination(n-1, r-1) + combination(n-1, r);
	}

}