import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 테스트케이스 T
		int T = Integer.parseInt(st.nextToken());

		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());

			// 의상의 수 N
			int N = Integer.parseInt(st.nextToken());

			Map<String, Integer> clothMap = new HashMap<>();
			while(N-- > 0) {
				// 의상의 이름, 종류
				st = new StringTokenizer(br.readLine(), " ");
				String name = st.nextToken();
				String kind = st.nextToken();

				clothMap.put(kind, clothMap.getOrDefault(kind, 0) + 1);
			}

			// 최종 경우의 수
			int sum = 1;

			for(String key : clothMap.keySet()) {
				// (종류별 옷의 개수 + 1)들의 곱으로 경우의 수 계산
				// +1 : 해당 종류의 옷을 입지 않음
				sum *= (clothMap.get(key)+1);
			}

			// 아무것도 입지 않는 경우는 제외
			sum--;
			bw.append(String.valueOf(sum)).append("\n");
		}

		bw.close();
		br.close();
	}
}