import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 가로 길이 n (1<= n <= 1000)
		int n = Integer.parseInt(br.readLine());

		// 2*n 직사각형을 1*2, 2*1, 2*2 직사각형으로 채우는 경우의 수 배열
		// ex) square[3] = 2*3 직사각형을 채우는 경우의 수
		long[] square = new long[n + 1];

		// 2*1 직사각형을 채우는 경우의 수는 한 가지 뿐이이다.
		square[1] = 1;

		if(n > 2) {
			// 2*2 직사각형을 채우는 경우의 수는 세 가지.
			square[2] = 3;
		} else {
			// n이 1 또는 2인 경우 처리
			System.out.println((n==1)? 1 : 3);
			return;
		}

		for(int i=3; i<=n; i++) {
			// n*i 직사각형을 채우는 경우의 수는
			// n*(i-1) 직사각형을 채운 경우의 수 --> 1*2 직사각형만 덧붙일 수 있음
			// n*(i-2) 직사각형을 채운 경우의 수 * 2 --> 2*1 직사각형 2개 or 2*2 직사각형 1개를 덧붙일 수 있음
			// 이 두 가지 경우를 합산한 값이다.
			square[i] = (square[i-1] + square[i-2] * 2) % 10007;	// 계산을 할 때마다 미리 오버플로우 방지
		}

		bw.append(String.valueOf(square[n]));

		bw.close();
		br.close();
	}
}