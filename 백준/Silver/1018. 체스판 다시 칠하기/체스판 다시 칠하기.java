import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input[] = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		String board[] = new String[N];
		
		// M*N 보드를 입력받음 
		for(int i=0; i<N; i++) {
			board[i] = br.readLine();
		}
		
		// 바꿔야 하는 최소값 
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<=N-8; i++) {
			for(int j=0; j<=M-8; j++) {
				// 보드의 시작점 i번째 줄의 j번째 정사각형
				
				// 시작점이 B일때 다시 칠해야 하는 사각형의 개수 
				int repaintB = 0;		
				// 시작점이 W일때 다시 칠해야 하는 사각형의 개수
				int repaintW = 0;
				
				// 잘라낸 8*8 보드판에서 다시 칠해야 하는 사각형의 개수 계산 
				for(int x=0; x<8; x++) {
					for(int y=0; y<8; y++) {
						// 잘라낸 보드판의 x번째줄 y번째칸의 색상 
						char square = board[i+x].charAt(j+y);
						
						// 체스판이 되기 위한 해당 칸의 색상
						// B: 첫칸이 B일때, W: 첫칸이 W일때 
						char expectedB = ((x+y)%2==0)? 'B': 'W';
						char expectedW = ((x+y)%2==0)? 'W': 'B';
						
						// 보드판의 색상이 기댓값과 다르면 색칠
						if(square != expectedB) { repaintB++; }
						if(square != expectedW) { repaintW++; }
					}					
				}
				
				// B일때 색칠한 칸의 개수 & W일때 색칠한 칸의 개수 중 더 작은 값과
				// min과 비교해서 더 작은 값을 min으로 재선언 
				min = Math.min(min, (Math.min(repaintW, repaintB)));				
			}		
		}
		
		System.out.println(min);
		
		br.close();
	}
}