import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 가장 아랫부분의 정사각형 개수 n이 주어진다. 
		// N의 범위가 int의 범위를 초과하므로 long 형을 써야한다. 
		long N = Long.parseLong(br.readLine());
		
		System.out.println(N*4);
		
		br.close();		
	}
}