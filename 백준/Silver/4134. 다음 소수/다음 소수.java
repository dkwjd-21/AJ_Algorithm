import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 테스트 케이스의 개수
		int T = Integer.parseInt(br.readLine());
		
//		System.out.println("T는 소수인가? : "+isPrime(T));
		
		// T번 반복
		for(int i=0; i<T; i++) {
			// 정수 n
			long n = Long.parseLong(br.readLine());
			
			// n보다 크거나 같은 소수 중 가장 작은 소수 출력
			while(!isPrime(n)) {
				// 소수가 아닐 경우 n++
				n++;
			}
			
			bw.append(n+"\n");
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