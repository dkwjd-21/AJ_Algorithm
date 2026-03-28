import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		long[] Fibonacci = new long[n + 1];

		if (n >= 0) Fibonacci[0] = 0;
		if (n >= 1) Fibonacci[1] = 1;

		for (int i = 2; i <= n; i++) {
			Fibonacci[i] = Fibonacci[i - 1] + Fibonacci[i - 2]; // 차곡차곡 더하기
		}

		System.out.println(Fibonacci[n]);

		br.close();
	}
}