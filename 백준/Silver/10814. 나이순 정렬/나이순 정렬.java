import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 온라인 저지 회원의 수 N 
		int N = Integer.parseInt(br.readLine());
		
		// N명의 회원 정보 입력
		String[] list = new String[N];
		for(int i=0; i<N; i++) {
			list[i] = br.readLine();
		}
		
		// 나이 우선 정렬 
		Arrays.sort(list, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				int age1 = Integer.parseInt(s1.split(" ")[0]);
				int age2 = Integer.parseInt(s2.split(" ")[0]);
				
				return age1-age2;
			}
		});
		
		for(String str : list) {
			bw.append(str+"\n");
		}
		
		bw.close();
		br.close();
	}
}