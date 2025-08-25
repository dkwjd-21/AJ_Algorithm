import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuffer sb = new StringBuffer();
	// 원판 이동 횟수 
	static int count = 0;
	
	public static void main(String[] args) throws IOException, NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 첫 번째 장대에 쌓인 원판의 개수 N
		int N = Integer.parseInt(br.readLine());
		
		hanoi(N, 1, 3, 2);
		System.out.println(count);
		System.out.print(sb);
		
		br.close();
	}
	
	// N개의 원판을 from -> to로 이동. tmp는 보조기둥. 
	static void hanoi(int N, int from, int to, int tmp) throws IOException{
		// 원판이 1개일 때 
		if(N==1) {
			count++;		// 이동횟수 추가
			// 수행과정 : from -> to 출력 
			sb.append(from + " " + to + "\n");
			return;
		}
		
		// N-1개를 보조 기둥으로 이동
		// ex) N=5. 4개(1, 2, 3, 4 순서)를 두번째 기둥으로 이동 
		hanoi(N-1, from, tmp, to);
		
		// 가장 큰 원판 이동
		// ex) N=5. 5번 원판을 세번째 기둥으로 이동 
		count++;			// 이동횟수 추가 
		sb.append(from + " " + to + "\n");
		
		// N-1개를 목표 기둥으로 이동
		// ex) N=5. 두번째 기둥의 위에서 부터 4, 3, 2, 1 순서로 세번째 기둥으로 이동
		hanoi(N-1, tmp, to, from);
	}
}