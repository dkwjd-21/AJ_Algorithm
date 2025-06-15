import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 수의 개수 N
		int N = Integer.parseInt(br.readLine());
		
		// 주어진 수 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 소수의 개수 cnt		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			int input = Integer.parseInt(st.nextToken());
			
			if(input == 1) {
				continue;
			}
			
			// 소수 여부
			boolean isPrime = true;
			
			// 소수 : 1과 자기 자신만을 약수로 가지는 수
			for(int j=2; j<input; j++) {
				if(input%j == 0) {
					isPrime = false;
				}
			}
			
			// input이 소수면 cnt ++
			if(isPrime) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		br.close();
	}
}