import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 전체 사람의 수 N
		int N = Integer.parseInt(br.readLine());

		// 몸무게와 키 배열
		int[][] body = new int[N][2];

		for(int i=0; i<N; i++) {
			String[] input = br.readLine().split(" ");
			body[i][0] = Integer.parseInt(input[0]);
			body[i][1] = Integer.parseInt(input[1]);
		}

		// 자신의 덩치 등수 = 자신보다 덩치가 큰 사람들의 수 + 1
		for(int i=0; i<N; i++) {
			// 자신보다 덩치가 큰 사람들의 수
			int cnt = 1;

			for(int j=0; j<N; j++) {
				// 비교대상이 자기 자신이 아닌 경우에만 비교
				if(i!=j) {
					// 몸무게와 키 모두 큰 경우에만 덩치가 크다고 판단
					if(body[i][0] < body[j][0] && body[i][1] < body[j][1]) {
						cnt++;
					}
				}
			}

			sb.append(cnt).append(" ");
		}

		System.out.println(sb);
		br.close();
	}
}