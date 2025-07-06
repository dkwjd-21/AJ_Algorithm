import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int cnt=0, tmp=1;
		
		while(true) {
			// tmp가 666을 포함하고 있으면 카운트
			if((tmp+"").contains("666")) cnt++;
			
			// 카운트 값이 N과 같아지면 반복문 종료
			if(cnt == N) {
				break;
			} else {
				// tmp 증감
				tmp++;
			}
		}
		
		// tmp 출력
		System.out.println(tmp);		
		br.close();
	}
}