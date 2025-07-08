import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 문자열의 개수 N과 M 
		String input[] = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		// N개의 문자열 입력. 집합 S. 같은 문자열은 없다. 
		HashSet<String> list = new HashSet<>();
		for(int i=0; i<N; i++) {
			list.add(br.readLine());
		}
		
		// M개의 검사해야 하는 문자열 입력.
		String target[] = new String[M];
		for(int i=0; i<M; i++) {
			target[i] = br.readLine();
		}
		
		// 몇 개가 집합 S에 포함되는지 출력한다. 
		int cnt = 0;
		for(int i=0; i<M; i++) {
			if(list.contains(target[i])) {
				cnt++;
			}
		}
		
		bw.append(cnt+"");
		bw.close();
		br.close();
	}
}