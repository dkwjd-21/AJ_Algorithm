import java.io.*;
import java.util.Arrays;

public class Main {
	static int minCnt = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		makeOne(N, 0);
		bw.append(String.valueOf(minCnt));

		bw.close();
		br.close();
	}

	static public void makeOne(int N, int cnt) {
		// 현재 카운트가 이미 최소카운트를 넘어선 경우 즉시종료
		if (cnt >= minCnt) return;

		if(N == 1) {
			minCnt = Math.min(minCnt, cnt);
		}

		if(N%3 == 0) makeOne(N/3, cnt+1);
		if(N%2 == 0) makeOne(N/2, cnt+1);
		makeOne(N-1, cnt+1);
	}
}