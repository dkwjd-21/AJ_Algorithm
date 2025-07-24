import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean[] prime = primeToN(1000000);
		
		// 테스트의 개수 T
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			// 짝수 N
			int N = Integer.parseInt(br.readLine());

			// 골드바흐 파티션의 수
			int cnt = 0;

			// N의 절반까지만 체크한다. (합은 대칭을 이루기 때문)
			for (int j = 0; j<=N/2; j++) {
				// 대칭을 이루는 두 수가 모두 소수이면 카운팅
				if(prime[j] && prime[N-j]) {
					cnt++;
				}
			}

			bw.append(cnt + "\n");
		}

		bw.close();
		br.close();
	}

	// 에라토스테네스의 체를 이용한 n이하의 소수 배열
	public static boolean[] primeToN(int n) {
		// 소수 배열 (고정된 배열)
		// 수의 범위 0~n (인덱스는 n+1 까지)
		boolean isPrime[] = new boolean[n+1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;

		// 에라토스테네스의 체
		for (int i = 2; i <= Math.sqrt(isPrime.length); i++) {
			if (isPrime[i]) {
				for (int j = i * i; j < isPrime.length; j += i) {
					isPrime[j] = false;
				}
			}
		}
		
		return isPrime;
	}
}