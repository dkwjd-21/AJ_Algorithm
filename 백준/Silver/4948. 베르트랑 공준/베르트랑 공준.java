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

		// 여러 개의 테스트 케이스
		while(true) {
			// 입력 n
			int n = Integer.parseInt(br.readLine());
			
			if(n==0) break;
			
			if(n==1) {
				// 1< x <= 2
				// 해당 범위 안에 들어오는 소수는 2밖에 없다. (개수 : 1)
				bw.append("1\n");
			} else {
				// 인덱스에 해당하는 수가 소수면 true, 소수가 아니면 false
				// 인덱스가 0부터 시작이므로 배열의 크기를 2n+1로 설정한다. 
				boolean[] isPrime = new boolean[2*n+1]; 
				Arrays.fill(isPrime, true);
				
				// 0과 1은 소수가 아니다.
				isPrime[0] = isPrime[1] = false;
				
				
				// 에라토스테네스의 체 구현
				for(int i=2; i*i <= 2*n; i++) {
					// 2의 배수부터 지운다.
					
					if(isPrime[i]) {
						// isPrime[i] = true
						// i가 소수 = 아직 지워지지 않음. 
						
						// i의 배수를 지운다. 
						// ex) i=2 -> j=4, 6, 8, 10 ...
						for(int j=i*i; j<=2*n; j+=i) {
							isPrime[j] = false;
						}
					}
				}
				
				// n < 출력할 범위 <= 2n
				// 인덱스는 n+1 <= 출력할 범위 <= 2n
				int cnt = 0;
				for(int i=n+1; i<=isPrime.length-1; i++) {
					if(isPrime[i]) cnt++;
				}
				
				bw.append(cnt+"\n");
			}
		}
		
		bw.close();
		br.close();
		// for문의 범위를 지정하는게 어려웠다. 
	}
}