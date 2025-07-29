import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 상의 N벌, 하의 N벌 
		int N = Integer.parseInt(br.readLine());
		
		// 전체 경우의 수 : N*N 
		// 색상이 같은 경우의 수 : N 

		bw.append(N*N - N +"");
		
		bw.close();
		br.close();
	}
}