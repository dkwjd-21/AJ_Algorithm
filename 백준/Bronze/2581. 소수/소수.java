import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());  
		
		// M 이상 N 이하의 자연수 중 소수인 것을 모두 고르기
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=M; i<=N; i++) {
			if(i==1) {
				continue;
			}			
			boolean isPrime = true;
			
			for(int j=2; j<i; j++) {
				if(i%j == 0) {
					isPrime = false;
				}
			}
			
			if(isPrime) {
				list.add(i);
			}
		}
		
		// 소수의 합
		int sum = 0;
		for(int i=0; i<list.size(); i++) {
			sum += list.get(i);
		}
		
		if(sum == 0) {
			System.out.println("-1");
		}else {
			System.out.println(sum);
			System.out.println(list.get(0));
		}	
		
		br.close();
	}
}