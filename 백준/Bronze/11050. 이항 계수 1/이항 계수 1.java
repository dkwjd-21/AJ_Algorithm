import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 자연수 N과 정수 K 
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		// (x+y)^n 의 k항의 계수는 
		// n C (k) 이다. 
		int num = 1;	// 분자 n*(n-1)*...*(n-k+1)
		for(int i=0; i<K; i++) {
			num *= N--;
		}
		
		int deno = 1; 	// 분모 k!
		for(int i=1; i<=K; i++) {
			deno *= i;
		}
		
		bw.append(num/deno+"");
		bw.close();
		br.close();
	}
}