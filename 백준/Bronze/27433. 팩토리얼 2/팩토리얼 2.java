import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 정수 N 
		int N = Integer.parseInt(br.readLine());
		
		// N! 출력 
		bw.append(factorial(N)+"");
		
		bw.close();
		br.close();
	}
	
	public static long factorial(int n) {
		if(n<=1) {
			return 1;
		}
		
		return n*factorial(n-1);
	}
}