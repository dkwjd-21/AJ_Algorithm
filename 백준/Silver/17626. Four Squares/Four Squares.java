import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 자연수 n (1 <= n <= 50,000)
		int n = Integer.parseInt(br.readLine());

		// n 이하의 제곱수
		List<Integer> squares = new ArrayList<>();
		for(int i=1; i*i<=n; i++) {
			squares.add(i*i);
		}

		// 동적계획법
		int[] dp = new int[n+1];
		// 라그랑주 정리 : 모든 자연수는 넷 혹은 그 이하의 제곱수의 합으로 표현할 수 있다
		Arrays.fill(dp, 4);
		dp[0] = 0;
		dp[1] = 1;	// 1을 만드는 방법은 1*1 뿐임

		for(int i=2; i<=n; i++) {
			// 현재 수 i를 만들기 위해 리스트에서 제곱수를 하나씩 뽑아서 덧셈
			for(int square : squares) {
				// 제곱수가 현재 수보다 크면 종료
				if(square > i)	break;
				// 현재 수(i)를 만들기 위해 제곱 수(sqaure) 사용한다면,
				// i-square를 만들기 위한 최소값 dp[i-square]에 제곱수(square) 1개 추가
				dp[i] = Math.min(dp[i], dp[i-square] + 1);
			}
		}

		bw.append(String.valueOf(dp[n]));

		bw.close();
		br.close();
	}

}