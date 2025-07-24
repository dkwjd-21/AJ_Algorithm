import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 정수 k
		int k = Integer.parseInt(br.readLine());
		
		// 장부 입력
		Stack<Integer> accountBook = new Stack<>();
		for(int i=0; i<k; i++) {
			// 정수 
			int money = Integer.parseInt(br.readLine());
			
			if(money == 0) {
				accountBook.pop();
			} else {
				accountBook.push(money);
			}
		}
		
		// 최종적으로 적어낸 수의 합
		int sum = 0;
		while(accountBook.size() != 0) {
			sum += accountBook.pop();
		}
		
		bw.append(sum+"");
		
		bw.close();
		br.close();
	}
}