import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 문자열 입력
		String input = br.readLine();
		
		for(int i=0; i<input.length(); i++) {
			char tmp = input.charAt(i);
			
			if('a'<=tmp && tmp<='z') {
				bw.append((tmp+"").toUpperCase());
			} else {
				bw.append((tmp+"").toLowerCase());
			}
		}
		
		bw.close();
		br.close();
	}
	
}