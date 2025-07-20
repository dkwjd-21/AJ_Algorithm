import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 자연수 N 
		int N = Integer.parseInt(br.readLine());
		
		// N개의 정수 
		Set<Integer> arrN = new HashSet<>();
		String[] input = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			arrN.add(Integer.parseInt(input[i]));
		}
		
		// 자연수 M
		int M = Integer.parseInt(br.readLine());
		
		// M개의 정수
		input = br.readLine().split(" ");
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(input[i]);
			
			if(arrN.contains(num)) {
				bw.append("1\n");
			} else {
				bw.append("0\n");
			}
		}
		
		bw.close();
		br.close();
	}
	
}