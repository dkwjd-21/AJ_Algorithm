import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line;

		// 자릿수가 모두 1로만 이루어진 n의 배수 중 가장 작은 수의 자리수를 출력한다.
		while((line = br.readLine()) != null) {
			int N = Integer.parseInt(line);

			// if N == 7
			// 11 = 7*1+4
			// 111 = 11*10+1			-> 11에 7*1+4 대입
			//	   = (7*1+4) * 10 + 1
			//     = 7*10 + 4*10 + 1
			// 111을 7로 나눈 나머지 = 4*10 + 1
			//					-> 4는 11을 7로 나눈 나머지임

			int remain = 0;
			for(int i=1; ; i++) {		// i는 자릿수를 의미함 (ex. i=3 -> 111)
				remain = (remain * 10 + 1) % N;

				if(remain == 0) {
					System.out.println(i);
					break;
				}
			}

		}
	}
}