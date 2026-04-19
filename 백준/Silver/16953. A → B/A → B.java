import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// A, B
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());

		makeNum(A, B, 1);

		if(cnt == Integer.MAX_VALUE) {
			cnt = -1;
		}

		bw.append(String.valueOf(cnt));

		bw.close();
		br.close();
	}

	static int cnt = Integer.MAX_VALUE;

	// curr을 target으로 만드는 함수
	public static void makeNum(long curr, long target, int currCnt) {
		if(curr == target) {
			cnt = Math.min(cnt, currCnt);
			return;
		}

		if(curr > target) {
			// 현재값이 타깃보다 커지면 더 이상 연산할 수 없음
			return;
		}

		// 2를 곱한다
		makeNum(curr*2, target, currCnt+1);
		// 맨 뒤에 1을 더한다
		makeNum(curr*10+1, target, currCnt+1);
	}
}