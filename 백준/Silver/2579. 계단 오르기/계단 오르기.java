import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 계단의 개수 : 300이하의 자연수
		int N = Integer.parseInt(br.readLine());
		// 각 계단의 점수
		int[] stairs = new int[N+1];
		for(int i=1; i<N+1; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}

		// 계단이 1개면
		if(N==1) {
			System.out.println(stairs[1]);
			return;
		}

		// 동적계획법으로 구현
		int[] dp = new int[N+1];
		dp[1] = stairs[1];				// 1번째 계단만 가는 경우
		dp[2] = stairs[1] + stairs[2];	// 1번째, 2번째 계단을 연달아 가는 경우

		for(int i=3; i<N+1; i++) {
			// 두 계단 전(i-2)에서 점프해서 오는 경우
			// 한 계단 전(i-1)에서 연달아 오는 경우 = i-2 계단을 지나면 안됨 = i-3 계단까지의 점수와 합산해야함
			dp[i] = Math.max(dp[i-2],
							 dp[i-3] + stairs[i-1]) + stairs[i];	// 현재 계단을 무조건 감
		}

		bw.append(String.valueOf(dp[N]));
		bw.close();
		br.close();
	}
}