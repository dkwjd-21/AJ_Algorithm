import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 창문의 개수 & 사람의 수 : N 
		int N = Integer.parseInt(br.readLine());
		
		// 1~N 중 약수가 홀수인 수만 최종적으로 문이 열려 있다. 
		// 약수가 홀수인 수는 완전제곱수밖에 없다. 
		
		// 완전제곱수의 수
		int cnt = 0;
		
		for(int i=1; i<=Math.sqrt(N); i++) {
			if(i*i <= N) {
				cnt++;
			}
		}
		
		bw.append(cnt+"");
		
		bw.close();
		br.close();
	}
}