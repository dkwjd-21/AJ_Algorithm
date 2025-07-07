import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 점의 개수 N
		int N = Integer.parseInt(br.readLine());
		
		// N개의 점 입력 
		String[] list = new String[N];
		for(int i=0; i<N; i++) {
			list[i] = br.readLine();
		}
		
		// Y 기준 우선정렬
		Arrays.sort(list, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				int x1 = Integer.parseInt(s1.split(" ")[0]);
				int y1 = Integer.parseInt(s1.split(" ")[1]);
				int x2 = Integer.parseInt(s2.split(" ")[0]);
				int y2 = Integer.parseInt(s2.split(" ")[1]);
				
				if(y1 == y2) {
					return x1-x2;
				} else {
					return y1-y2;
				}
			}
		});
		
		for(int i=0; i<N; i++) {
			System.out.println(list[i]);
		}
		
		br.close();
	}
}