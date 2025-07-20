import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 두 개의 자연수
		String[] input = br.readLine().split(" ");
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		
		// 최대공약수
		int GCD = GCD(a, b);
		bw.append(GCD+"\n");
		// 최소공배수
		bw.append(a*b/GCD+"");
		
		bw.close();
		br.close();
	}
	
	public static int GCD(int a, int b) {
		int tmp = a;
		a = Math.max(a, b);
		b = Math.min(tmp, b);
	
		while(b!=0) {
			tmp = b;
			b = a%b;
			a = tmp;
		}
		
		return a;
	}
}