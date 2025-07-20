import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 두 도메인의 유명도 N, M 
		String[] input = br.readLine().split(" ");
		long N = Long.parseLong(input[0]);
		long M = Long.parseLong(input[1]);
		
		// 첫째 줄에 두 유명도의 차이 (|N-M|)을 출력한다.
		bw.append(Math.abs(N-M)+"");
		
		bw.close();
		br.close();
	}
	
}