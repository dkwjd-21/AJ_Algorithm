import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 테스트의 개수 T 
		int T = Integer.parseInt(br.readLine());
		
		// T 줄에 걸쳐 A와 B가 주어진다. 
		for(int i=0; i<T; i++) {
			String input[] = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			
			int tmp = a, GCD;
			a = Math.max(a, b);
			b = Math.min(tmp, b);
			
			// 최소공약수 계산 
			GCD = GCD(a, b);
			
			// a와 b의 최소공배수를 출력. 
			// 최소공배수 = 두 자연수의 곱 / 최대공약수 
			bw.append(a*b/GCD+"\n");
		}
		
		
		bw.close();
		br.close();
	}
	
	// 최대공약수를 구하는 함수 (a > b) 
	public static int GCD(int a, int b) {
		// A = i*B + j
		// j가 0이면 GCD = B
		// j>0 이면 GCD = B와 j의 GCD
		
		// -> B가 a, j가 b가 되어 위의 과정 다시 진행. 
		// b가 0이될 때까지 반복한다. 
		while(b!=0) {
			int tmp = b;
			b = a%b;		// j로 대입
			a = tmp;		// b로 대입
		}
		return a;			// b가 0, 나머지가 0일 때의 값 리턴
	}
}