import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 전체 수의 개수 N, 합을 구해야 하는 횟수 M
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 인덱스 1부터 i까지의 부분 합을 저장할 배열
		int[] partialSum = new int[N+1];
		partialSum[0] = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<N+1; i++) {
			partialSum[i] = partialSum[i-1] + Integer.parseInt(st.nextToken());
		}

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());

			// i부터 j까지의 합
			// == 1부터 j까지의 합 - 1부터 i-1까지의 합
			int sum = partialSum[j] - partialSum[i-1];
			bw.append(String.valueOf(sum)).append("\n");
		}

		bw.close();
		br.close();
	}
}