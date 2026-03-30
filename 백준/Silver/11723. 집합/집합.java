import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 수행해야 하는 연산의 수 M
		int M = Integer.parseInt(br.readLine());

		boolean[] S = new boolean[21];

		for(int i=0; i<M; i++) {
			String[] input = br.readLine().split(" ");

			if (input[0].equals("all")) {
				Arrays.fill(S, true);
			} else if (input[0].equals("empty")) {
				Arrays.fill(S, false);
			} else {
				int x = Integer.parseInt(input[1]);

				switch (input[0]) {
					case "add":
						S[x] = true;
						break;
					case "remove":
						S[x] = false;
						break;
					case "check":
						sb.append(S[x] ? 1 : 0).append("\n");
						break;
					case "toggle":
						S[x] = !S[x];
						break;
				}
			}
		}

		System.out.println(sb);
		br.close();
	}
}