import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 동전의 종류 N, 목표 금액 K
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);

		// N개 동전의 값어치 (오름차순)
		int[] coin = new int[N];
		for(int i=0; i<N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		// 동전 개수의 최소값
		int cnt = 0;

		for(int i=N-1; i>=0; i--) {
			int curr = coin[i];

			if(K/curr >= 1) {
				// 현재 코인을 낼 수 있다면
				cnt += K/curr;
				K %= curr;
			}
		}

		System.out.println(cnt);
		br.close();
	}
}