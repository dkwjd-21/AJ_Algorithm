import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 첫째줄에 N이 주어진다. 
		int N = Integer.parseInt(br.readLine());
		
		// 단계별 숫자 범위 
		/* 1단계 : 1
		 * 2단계 : 2~7 (6개) 
		 * 3단계 : 8~19 (12개) 
		 * ... 
		 * */
		int min = 1, max = 1;
		// 단계
		int level = 1;		
		
		// 반복문 제어용 bool
		boolean isEnd = false;
		
		while(true) {
			for(int i=min; i<=max; i++) {
				if(N == i) {
					isEnd = true;
					break;
				}
			}	
			
			if(isEnd) {
				break;
			}else {
				min = max + 1;
				max = max + 6*level;
				level++;
			}			
		}		
		
		System.out.println(level);
		
	}
}