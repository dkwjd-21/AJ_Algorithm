import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 녹색거탑의 높이를 나타내는 정수 N 
		int N = Integer.parseInt(br.readLine());
		
		// n층에서 내려올 수 있는 방법은 2^n이다. 
		int res = (int) Math.pow(2, N);
		bw.append(res+"");
		
		bw.close();
		br.close();
	}
}