import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력의 크기 n
		int n = Integer.parseInt(br.readLine());
		
		System.out.println((long)n*(n-1)/2);	// 수행 횟수 
		System.out.println(2);	// 최고차항의 차수
		
		br.close();
	}
}