import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 사람의 수 N
		int N = Integer.parseInt(br.readLine());
		// 각 사람들이 돈을 인출하는 데 걸리는 시간
		String[] input = br.readLine().split(" ");
		int[] time = new int[N];

		for(int i=0; i<N; i++) {
			time[i] = Integer.parseInt(input[i]);
		}

		// 시간이 적게 걸리는 순으로 해야 최솟값
		Arrays.sort(time);
		int[] spendTime = new int[N];
		spendTime[0] = time[0];

		for(int i=1; i<N; i++) {
			spendTime[i] = spendTime[i-1] + time[i];
		}

		int totalTime = 0;
		for(int tmp : spendTime) {
			totalTime = totalTime + tmp;
		}

		bw.append(String.valueOf(totalTime));

		bw.close();
		br.close();
	}
}