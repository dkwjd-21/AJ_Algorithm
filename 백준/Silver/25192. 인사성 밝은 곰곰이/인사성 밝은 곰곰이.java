import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 채팅방의 기록 수 N 
		int N = Integer.parseInt(br.readLine());
		String[] input = new String[N];
		
		// N개의 채팅방 기록
		for(int i=0; i<N; i++) {
			input[i] = br.readLine();
		}
		
		Set<String> talk = new HashSet<>();
		int cnt = 0;
	
		for(int i=0; i<N; i++) {
			if(input[i].equals("ENTER")) {
				talk.clear();
			} else if(!talk.contains(input[i])) {
				talk.add(input[i]);
				cnt++;
			}
		}
		
		bw.append(cnt+"");
		
		bw.close();
		br.close();
	}
}