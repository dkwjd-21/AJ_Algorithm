import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		long sumToN = 0;

		// 1부터 N까지의 약수들의 합
		for(int i=1; i<=N; i++) {
			// i가 N까지의 수에서 몇 번 약수로 등장하는지 체크
			sumToN += (long) i * (N/i);
		}

		System.out.println(sumToN);
		br.close();
	}
}