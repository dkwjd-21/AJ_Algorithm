import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 첫번째 손님은 101호. 두번째 201 ~~ n01 . 
		
		// T개의 테스트 데이터 
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			String input[] = br.readLine().split(" ");
			// H층까지
			int H = Integer.parseInt(input[0]);
			// N번째 손님
			int N = Integer.parseInt(input[2]);
			
			// 몇 층? 
			int floor = (N%H == 0)? H:(N%H);
			// 몇 호? 
			int room = (N%H == 0)? (N/H):(N/H)+1;
			
			// 출력
			// %d : 정수형 
			// %02d : 항상 2자리 정수형 (ex. 01, 02, ...)
			bw.write(String.format("%d%02d\n", floor, room));
		}
		
		bw.close();
		br.close();
	}
}