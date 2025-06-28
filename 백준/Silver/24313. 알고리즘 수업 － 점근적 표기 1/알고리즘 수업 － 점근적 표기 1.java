import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// a1(코드에서는 a로 표기), a0(코드에서는 b로 표기) 입력
		String[] input = br.readLine().split(" ");
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		
		// c 입력 
		int c = Integer.parseInt(br.readLine());
		
		// 양의 정수 n0(코드에서는 n으로 표기) 입력
		int n = Integer.parseInt(br.readLine());
		
		// (c-a)n-b >= 0 이어야 한다. 
		// 동시에 (c-a) >= 0
		if( (c-a)>=0 && (c-a)*n-b >=0 ) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}		
		
		br.close();
	}
}