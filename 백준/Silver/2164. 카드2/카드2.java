import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 정수 N 
		int N = Integer.parseInt(br.readLine());
		
		// 1부터 N까지의 숫자 카드가 순서대로 놓여 있다. 
		Queue<Integer> card = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			card.add(i);
		}
		
		// card.size()가 1이 될때까지 반복한다.
		while(card.size()!=1) {
			// 맨 위의 카드를 삭제한다. 
			card.poll();
			
			if(card.size()==1) break;
			
			// 그다음의 맨 위의 카드를 맨 뒤로 보낸다. 
			card.add(card.poll());
		}
		
		// 남은 카드의 번호를 출력한다. 
		bw.append(card.element()+"");
		
		bw.close();
		br.close();
	}
	
}