import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String N = br.readLine();
		
		for(int i=9; i>=0; i--) {
			if(N.contains(i+"")) {
				// i가 들은 개수 카운팅 
				int cnt = N.length() - N.replaceAll(i+"", "").length();
				
				// 개수만큼 i 출력 
				for(int j=0; j<cnt; j++) {
					System.out.print(i);
				}
			}			
		}
		
		br.close();
	}
}