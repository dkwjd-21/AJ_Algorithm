import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// A와 B 입력
		String[] input = br.readLine().split(" ");
		long A = Long.parseLong(input[0]);
		long B = Long.parseLong(input[1]);
		
		// A와 B의 최대공약수
		long gcd = GCD(A, B);
		
		// A와 B의 최소공배수
		bw.append(A*B/gcd+"");
		
		bw.close();
		br.close();
	}
	
	// 최대공약수를 구하는 함수 (a > b) 
	public static long GCD(long a, long b) {
		long t = a;
		a = Math.max(a, b);
		b = Math.min(t, b);
		
		while(b!=0) {
			long tmp = b;
			b = a%b;		// j로 대입
			a = tmp;		// b로 대입
		}
		return a;			// b가 0, 나머지가 0일 때의 값 리턴
	}
}