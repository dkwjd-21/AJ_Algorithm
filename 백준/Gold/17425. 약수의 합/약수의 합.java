import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 최대 범위까지 약수의 합(f) 미리 계산
		long[] f = new long[1000001];
		for (int i = 1; i <= 1000000; i++) {
			for (int j = 1; i * j <= 1000000; j++) {
				// i의 배수에 해당하는 원소(해당 인덱스의 약수의 합)에 i를 합산 
				f[i * j] += i; // i는 i*j의 약수이므로 누적
			}
		}

		// 1부터 N까지의 f값들의 누적합(g) 계산
		long[] g = new long[1000001];
		for (int i = 1; i <= 1000000; i++) {
			g[i] = g[i - 1] + f[i];
		}

		int T = Integer.parseInt(br.readLine());

		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			long sumToN = g[N];
			sb.append(sumToN).append("\n");
		}

		System.out.print(sb.toString());
	}
}