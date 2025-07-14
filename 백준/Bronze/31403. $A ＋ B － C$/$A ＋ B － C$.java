import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		// 첫번째 경우 : 수식 계산
		bw.append((A+B-C)+"\n");
		// 두번째 경우 : 문자열+수식 
		bw.append(Integer.parseInt(A+""+B)-C+"");
		bw.close();
		br.close();
	}
}