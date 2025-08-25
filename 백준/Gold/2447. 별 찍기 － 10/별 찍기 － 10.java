import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static char[][] result;
	
	public static void main(String[] args) throws IOException, NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 3의 거듭제곱 N
		int N = Integer.parseInt(br.readLine());
		result = new char[N][N];
		
		// N * N의 문자열을 만들기 
		for(int x=0; x<N; x++) {
			for(int y=0; y<N; y++) {
				star(x, y, N);
			}
		}
		
		
		// 출력
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				bw.append(result[i][j]);
			}
			bw.append("\n");
		}
		
		
		bw.close();
		br.close();
	}
	
	// (x, y) 좌표에 해당하는 값 저장하기. (1,1) = 첫번째 줄의 첫번째 칸.  
	static void star(int x, int y, int N) {
	    if (N == 1) { // 더 이상 쪼갤 수 없으면
	        result[x][y] = '*';
	        return;
	    }

	    int tmp = N / 3;

	    if ((x / tmp) % 3 == 1 && (y / tmp) % 3 == 1) { // 중앙 블록이면 공백
	        result[x][y] = ' ';
	    } else {
	        star(x, y, tmp); // 나머지 블록이면 재귀
	    }
	}

}