import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 자연수 N 
		int N = Integer.parseInt(br.readLine());
		
		// 1부터 (N-N의자리수)까지 for문을 돌면서 생성자 구하기 
		int result = 0;
		int length = (N+"").length();
		
		for(int i=1; i<=N-length; i++) {
			if(sum(i)==N) {
				result = i;
				break;
			}
		}		
			
		System.out.println(result);
		br.close();
	}
	
	// 자연수 num의 분해합을 구하는 함수
	public static int sum(int num) {
		int res = num;
		
		while(num!=0) {
			res += num%10;
			num = num/10;
		}
		
		return res;
	}
}