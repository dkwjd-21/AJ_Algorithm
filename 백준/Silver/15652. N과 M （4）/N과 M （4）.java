import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	// 전역 변수로 사용할 값 
	static int N, M;
	static int[] arr;			// M개의 수를 저장할 배열
	// 시간초과를 해결하기 위해 스트링버퍼 사용
	static StringBuffer result = new StringBuffer("");	// 출력할 결과
 	
	public static void main(String[] args) throws IOException, NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 자연수 N과 M이 주어진다.
		// 1부터 N까지 자연수 중에서 중복 없이 M개를 골라야 한다. 
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		// M개의 수를 저장할 배열 
		arr = new int[M];
		
		// 백트래킹 시작. 
		back(0, 0);
		bw.append(result);
		
		bw.close();
		br.close();
	}
	
	static void back(int depth, int param) {
		
		// M개의 수를 저장했다면 종료, 출력 
		if(depth == M) {
			for(int i : arr) {
				result.append(i).append(" ");
			}
			result.append("\n");
			return;
		}
		
		
		for(int i=param; i<N; i++) {
			arr[depth] = i+1;
			// 비내림차순 : 오름차순과 유사하지만, a1 = a2 여도 되는 정렬 방식. 
			// 따라서 반복문의 i값을 그대로 파라미터로 넘겨준다. 
			back(depth+1, i);
		}
		
	}
}