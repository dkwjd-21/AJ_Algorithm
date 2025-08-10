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

		// 영어 지문에 나오는 단어의 개수 M 
		// 외울 단어의 길이 기준이 되는 M 
		// 사람들이 만난 기록의 수 N
				int N = Integer.parseInt(br.readLine());
				
				// 춤을 추고 있는 사람들의 이름
				Set<String> dance = new HashSet<>();
				dance.add("ChongChong");
				
				for(int i=0; i<N; i++) {
					String people[] = br.readLine().split(" ");
					
					// 기록 중 총총이 or 춤을 추고 있는 사람이 있다면? 
					if(dance.contains(people[0])) {
						dance.add(people[1]);
					} else if(dance.contains(people[1])) {
						dance.add(people[0]);
					}
				}
				
				bw.append(dance.size()+"");
		
		bw.close();
		br.close();
	}
}