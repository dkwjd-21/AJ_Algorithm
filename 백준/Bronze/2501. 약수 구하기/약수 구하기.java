import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// input 
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		int[] arr = new int[N];
		
		// 약수의 개수
		int cnt = 0;
		// K번째 약수 
		int meaK = 0;
		// 약수일 때 1로 설정
		for(int i=1; i<=N; i++) {
			if(N%i == 0) {
				arr[i-1] = 1;
				// 약수 개수 
				cnt++;
				if(cnt==K) {
					meaK = i;
				}
			}
		}
		
		
		System.out.println(meaK);		
		br.close();
	}
}