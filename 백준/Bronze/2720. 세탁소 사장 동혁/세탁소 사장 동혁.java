import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 테스트 케이스의 개수 T
		int T = Integer.parseInt(br.readLine());
		
		// 쿼터 다임, 니켈, 페니의 개수
		int[] cnt = new int[4];
		
		// T만큼 반복
		for(int i=0; i<T; i++) {
			// 거스름돈 C (센트 단위) 
			int C = Integer.parseInt(br.readLine());
			
			// 쿼터 개수
			cnt[0] = C/25;
			C -= cnt[0]*25;
			
			// 다임 개수
			cnt[1] = C/10;
			C -= cnt[1]*10;
			
			// 니켈 개수
			cnt[2] = C/5;
			C -= cnt[2]*5;
			
			// 페니 개수
			cnt[3] = C;	
			
			// 개수 출력
			for(int j=0; j<cnt.length; j++) {
				System.out.print(cnt[j]+" ");
			}
		}		
		
		br.close();
	}
}