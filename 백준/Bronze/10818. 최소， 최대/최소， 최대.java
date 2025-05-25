import java.io.*;

public class Main {	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 첫째 줄에 정수의 개수 N이 주어진다
		int N = Integer.parseInt(br.readLine());
		
		// 둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다. 
		int[] arr = new int[N];
		String[] input = br.readLine().split(" ");
		
		// 정수 N개의 최솟값과 최댓값을 공백으로 구분해 출력한다. 
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		int min = arr[0];
		int max = arr[0];
		
		for(int i=0; i<N; i++) {
			if(min > arr[i]) {
				min = arr[i];
			}
			
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		
		System.out.println(min + " " + max);		
	}
}