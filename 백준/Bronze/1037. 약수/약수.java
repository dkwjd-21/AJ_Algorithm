import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 진짜 약수 : 1과 N을 제외한 약수. 
		
		// N의 진짜 약수의 개수 
		int cnt = Integer.parseInt(br.readLine());
		
		String input[] = br.readLine().split(" ");
		int mea[] = new int[cnt];
		
		// N의 진짜 약수 
		for(int i=0; i<cnt; i++) {
			mea[i] = Integer.parseInt(input[i]);
		}
		
		Arrays.sort(mea);
		int N = (cnt==1)? mea[0]*mea[0]:mea[0]*mea[cnt-1];
		
		// N을 출력
		System.out.println(N);
				
		br.close();
	}
}