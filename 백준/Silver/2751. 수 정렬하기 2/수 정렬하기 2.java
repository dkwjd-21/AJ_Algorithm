import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 수의 개수  N <= 1,000,000  
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
//		int list[] = new int[N];
		
		// O(n)
		for(int i=0; i<N; i++) {
//			list[i] = Integer.parseInt(br.readLine());
			list.add(Integer.parseInt(br.readLine()));
		}
		
		// O(NlogN) - 최악 O(N^2)
		// Arrays.sort(list);
		
		// 평균&최악 O(NlogN)
		Collections.sort(list);
		
		// O(n) 
		for(int i : list) {
			bw.write(i+"\n");
		}
		
		bw.close();
		br.close();
	}
}