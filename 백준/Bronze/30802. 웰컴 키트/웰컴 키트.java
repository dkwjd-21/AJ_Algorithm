import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 참가자의 수 N
		int N = Integer.parseInt(br.readLine());
		// S, M, L, XL, XXL, XXXL 최소수량 
		String shirts[] = br.readLine().split(" ");
		// 티셔츠 T장 묶음 & 펜 P개 묶음 
		String input[] = br.readLine().split(" ");
		int T = Integer.parseInt(input[0]);
		int P = Integer.parseInt(input[1]);
		
		// 티셔츠 최소 몇 묶음? 
		int cnt = 0;
		for(int i=0; i<shirts.length; i++) {
			int shirt = Integer.parseInt(shirts[i]);
			
			if(shirt == 0) {
				cnt += 0;
			} else if(shirt <= T) {
				cnt++;
			} else {
				cnt += (shirt%T == 0)? shirt/T : shirt/T + 1;
			}			
		}
		bw.write(cnt+"\n");
		
		// 펜 최소 몇 묶음 & 몇 자루 
		bw.write( (N/P)+" "+(N%P) );
		
		bw.close();
		br.close();
	}
}