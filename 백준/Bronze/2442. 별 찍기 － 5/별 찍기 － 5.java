import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		// 4 3 2 1 0 
		// 1 3 5 7 9 
		
		for(int i=1; i<=N; i++) {
			for(int j=N-i; j>0; j--) {
				System.out.print(" ");
			}
			for(int j=0; j<2*i-1; j++) {
				System.out.print("*");
			}
			System.out.println();		
		}
		
		br.close();
	}
}