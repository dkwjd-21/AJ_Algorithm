import java.io.*;

public class Main {	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 첫째 줄부터 아홉 번째 줄까지 한 줄에 하나의 자연수가 주어진다
		int[] input = new int[9];
		for(int i=0; i<input.length; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		// 첫째 줄에 최댓값을 출력하고, 둘째 줄에 최댓값이 몇 번째 수인지를 출력한다.
		int max = input[0];
		int idx = 0;
		for(int i=0; i<input.length; i++) {
			if(max < input[i]) {
				max = input[i];
				idx = i;
			}
		}		
		System.out.println(max);
		System.out.println(idx+1);		
	}
}