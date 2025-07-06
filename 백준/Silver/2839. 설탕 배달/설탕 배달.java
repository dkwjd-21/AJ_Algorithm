import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 배달해야 하는 설탕의 무게 N kg
		int N = Integer.parseInt(br.readLine());
		
		// 봉지의 개수 
		int min = Integer.MAX_VALUE;
		
		// 5x + 3y = N 을 만족해야한다. 
		// min = x+y
		
		for(int x=0; x<=N/5; x++) {
			int remain = N - 5*x;
			
			if(remain % 3 ==0) {
				int y = remain/3;
				min = Math.min(min, x+y);
			}
		}
		
		// min이 여전히 MAX_VALUE일 때는 조건을 만족하는 x, y가 없다는 의미
		System.out.println( (min==Integer.MAX_VALUE)? -1:min );				
		br.close();
	}
}