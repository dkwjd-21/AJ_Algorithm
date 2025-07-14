import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 각 숫자를 제곱한 수들의 합
		int sum = 0;
		
		// 고유번호 처음 5자리 숫자 
		for(int i=0; i<5; i++) {
			int num = Integer.parseInt(st.nextToken());
			sum += num*num;
		}
		
		bw.write(sum%10+"");
		bw.close();
		br.close();
	}
}