import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 0 <= N <= 40
		// 0부터 40까지 피보나치 수에서 0과 1이 등장하는 개수 카운트
		int[][] cnt = new int[41][2];

		// 0은 0이 1개, 1이 0개
		// 1은 0이 0개, 1이 1개
		cnt[0][0] = 1; cnt[0][1] = 0;
		cnt[1][0] = 0; cnt[1][1] = 1;

		for(int i=2; i<41; i++) {
			// i번째 -> 0이 등장하는 개수 피보나치 수열로 계산
			cnt[i][0] = cnt[i-1][0] + cnt[i-2][0];
			// i번째 -> 1이 등장하는 개수 피보나치 수열로 계산
			cnt[i][1] = cnt[i-1][1] + cnt[i-2][1];
		}

		// 테스트 케이스의 수 T
		int T = Integer.parseInt(br.readLine());

		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());

			// 0 개수, 1 개수 출력
			bw.append(String.valueOf(cnt[N][0])).append(" ");
			bw.append(String.valueOf(cnt[N][1])).append("\n");
		}

		bw.close();
		br.close();
	}
}