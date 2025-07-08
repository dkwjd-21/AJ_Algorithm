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
		
		// 가지고 있는 숫자 카드의 개수 N 
		int N = Integer.parseInt(br.readLine());
		
		// N개 카드에 적혀있는 정수 (같은 수는 없다) 
		HashSet<Integer> card = new HashSet<>();
		String input[] = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			card.add(Integer.parseInt(input[i]));
		}
		
		// 타겟 카드의 개수 M 
		int M = Integer.parseInt(br.readLine());
		
		// 타겟 카드에 적혀있는 정수 
		int target[] = new int[M];
		input = br.readLine().split(" ");
		for(int i=0; i<M; i++) {
			target[i] = Integer.parseInt(input[i]);
		}
		
		// card와 target[] 체크 
		for(int i : target) {
			if(card.contains(i)) {
				bw.append(1+" ");
			}else {
				bw.append(0+" ");
			}			
		}
		
		
		bw.close();
		br.close();
	}
}