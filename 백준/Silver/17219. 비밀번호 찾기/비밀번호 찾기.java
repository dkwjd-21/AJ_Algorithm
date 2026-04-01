import java.io.*;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 저장된 사이트의 수 N, 비밀번호를 찾으려는 사이트의 수 M
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		HashMap<String, String> passwordMap = new HashMap<String, String>();
		for(int i=0; i<N; i++) {
			input = br.readLine().split(" ");
			passwordMap.put(input[0], input[1]);
		}

		for(int i=0; i<M; i++) {
			sb.append(passwordMap.get(br.readLine())).append("\n");
		}

		System.out.println(sb);
		br.close();
	}
}