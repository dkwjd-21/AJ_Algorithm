import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 수의 개수 N
		int N = Integer.parseInt(br.readLine());
		
		// 수의 범위 1~10000
		int list[] = new int[10000];
		
		// N개의 수 입력 받기
		for(int i=0; i<N; i++) {
			// 입력받은 수에 해당하는 요소의 값을 증가 
			list[Integer.parseInt(br.readLine())-1]++;
		}
		
		// 카운팅 정렬
		for(int i=0; i<list.length; i++) {
			while(list[i]>0) {
				// 해당 인덱스에 해당하는 값이 0보다 클 때 인덱스 출력
				bw.append((i+1)+"\n");
				
				// 출력한 만큼 감소
				list[i]--;
			}
		}
		
		bw.close();	
		br.close();
	}
}