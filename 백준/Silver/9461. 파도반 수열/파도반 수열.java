import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 테스트 케이스 T
		int T = Integer.parseInt(br.readLine());

		// N의 범위 : 1~100
		long[] wave = new long[101];
		wave[1] = wave[2] = wave[3] = 1;
		for(int i=4; i<=100; i++) {
			wave[i] = wave[i-2] + wave[i-3];
		}

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			bw.append(String.valueOf(wave[N])).append("\n");
		}

		bw.close();
		br.close();
	}
}