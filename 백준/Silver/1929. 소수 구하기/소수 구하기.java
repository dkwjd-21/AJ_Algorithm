import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 자연수 M과 N (1<=M<=N<=1,000,000) 
		String[] input = br.readLine().split(" ");
		int M = Integer.parseInt(input[0]);
		int N = Integer.parseInt(input[1]);
		
		// M이상 N이하의 소수 출력 
		for(int i=M; i<=N; i++) {
			if(isPrime(i)) {
				bw.append(i+"\n");
			}
		}
		
		bw.close();
		br.close();
	}
	
	// 자연수 a가 소수인지 아닌지 판별하는 함수
	public static boolean isPrime(long a) {
		// 2부터 √n까지 나눠보면서 나누어떨어지면 false, 아니면 true
		// 약수는 항상 쌍으로 존재함 = 제곱근을 기준으로 대칭인 쌍
		// ex) 16의 약수 -> 1, 2, 4(제곱근), 8, 16 
		
		// 1은 소수가 아니다.
		if(a < 2) return false;		
		
		for(long i=2; i<=Math.sqrt(a); i++) {
			if(a%i == 0) {
				return false;
			}
		}
		
		return true;
	}
}