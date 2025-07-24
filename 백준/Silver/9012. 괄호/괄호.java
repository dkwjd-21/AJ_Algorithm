import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// T개의 테스트 데이터
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			String input = br.readLine();
			
			while(input.contains("()")) {
				input = input.replace("()", "");
			}
			
			if(input.isBlank()) {
				bw.append("YES\n");
			} else {
				bw.append("NO\n");
			}
		}
		
		bw.close();
		br.close();
	}
}