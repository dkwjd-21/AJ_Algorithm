import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		// N~1 까지 수들의 약수에 5가 몇개있는지 체크
		// 5*2 -> 10이므로 0의 개수는 5의 개수에 달려있음
		int cnt = 0;

		for(int i=N; i>0; i--) {
			int tmp = i;
			while(tmp%5 == 0) {
				cnt++;
				tmp /= 5;
			}
		}

		System.out.println(cnt);
		br.close();
	}
}