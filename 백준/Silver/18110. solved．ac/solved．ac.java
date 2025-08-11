import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static int cnt=0;
	static ArrayList<Integer> swap = new ArrayList<>();
	static int[] tmp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 난이도 의견의 개수 n
		int n = Integer.parseInt(br.readLine());
		
		// n개의 난이도 의견 
		int[] levels = new int[n];
		for(int i=0; i<n; i++) {
			levels[i] = Integer.parseInt(br.readLine());
		}
		
		// n명의 15% 반올림 값 
		int tmp = (int)Math.round(n*0.15);
		
		// 오름차순 정렬
		Arrays.sort(levels);
		
		int sum = 0, cnt=0;
		for(int i=tmp; i<n-tmp; i++) {
			sum += levels[i];
			cnt++;
		}
		
		double res = (double)sum/cnt;
		
		bw.append(Math.round(res)+"");
		
		bw.close();
		br.close();
	}	
} 