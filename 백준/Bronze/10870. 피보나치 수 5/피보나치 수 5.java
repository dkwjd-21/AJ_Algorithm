import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// n 
		int n = Integer.parseInt(br.readLine());
		
		// n번째 피보나치 수 
		bw.append(Fibonacci(n)+"");
		
		bw.close();
		br.close();
	}
	
	public static int Fibonacci(int n) {
		if(n==0) return 0;
		if(n==1) return 1;
		
		return Fibonacci(n-1)+Fibonacci(n-2);
	}
}