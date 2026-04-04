import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		List<Integer> makeN = new ArrayList<>();

		makeN.add(0);	// 0을 만드는 방법 0개 (인덱스 관리를 위해 추가)
		makeN.add(1);	// 1을 만드는 방법은 {1}
		makeN.add(2);	// 2를 만드는 방법은 {1+1, 2}
		makeN.add(4);	// 3을 만드는 방법은 {1+1+1, 1+2, 2+1, 3}

		// n의 범위는 양수이며 11보다 작다.
		for(int n=4; n<11; n++) {
			// j를 만드는 방법 = j-1을 만들어 1를 더하기 + j-2를 만들어 2를 더하기 + j-3을 만들어 3을 더하기
			makeN.add(makeN.get(n-1) + makeN.get(n-2) + makeN.get(n-3));
		}


		// 테스트 케이스의 수 T
		int T = Integer.parseInt(br.readLine());

		for(int i=0; i<T; i++) {
			// 1, 2, 3의 합으로 만들어야 하는 수 n
			int n = Integer.parseInt(br.readLine());
			bw.append(String.valueOf(makeN.get(n))).append("\n");
		}

		bw.close();
		br.close();
	}
}