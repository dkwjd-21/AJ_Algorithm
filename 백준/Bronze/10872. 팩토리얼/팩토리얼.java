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
		int sum = 1;
		for(int i=1; i<=N; i++) {
			sum *= i;
		}
		
		bw.append(sum+"");
		
		bw.close();
		br.close();
	}
	
}