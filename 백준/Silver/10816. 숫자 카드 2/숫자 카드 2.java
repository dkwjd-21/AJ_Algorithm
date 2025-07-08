import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 가지고 있는 숫자 카드의 개수 N
		int N = Integer.parseInt(br.readLine());
		
		// N개의 숫자 카드 입력 <카드숫자, 개수>
		HashMap<String, Integer> card = new HashMap<>();
		String input[] = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			if(card.containsKey(input[i])) {
				int tmp = card.get(input[i])+1;
				card.replace(input[i], tmp);
			} else {
				card.put(input[i], 1);
			}
		}
		
		// 테스트 할 카드의 개수 M 
		int M = Integer.parseInt(br.readLine());
		
		// M개의 숫자 입력
		input = br.readLine().split(" ");
		
		// 카드의 개수 출력
		for(int i=0; i<M; i++) {
			if(card.containsKey(input[i])) {
				bw.append(card.get(input[i])+" ");
			} else {
				bw.append(0+" ");
			}			
		}
		
		bw.close();
		br.close();
	}
}