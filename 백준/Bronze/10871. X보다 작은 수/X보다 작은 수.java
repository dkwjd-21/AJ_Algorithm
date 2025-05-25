import java.io.*;

public class Main {	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 첫째 줄에 N과 X가 주어진다. 
		String[] input1 = br.readLine().split(" ");;
		int N = Integer.parseInt(input1[0]);	// 정수 N
		int X = Integer.parseInt(input1[1]);	// 정수 X 
		
		// 수열 A를 이루는 정수 N개 
		int[] A = new int[N];
		String[] input2 = br.readLine().split(" ");
		
		// X보다 작은 수를 입력받은 순서대로 공백으로 구분해 출력
		for(int i=0;i<N;i++) {
			A[i] = Integer.parseInt(input2[i]);
			if(A[i] < X) {
				System.out.print(A[i]+" ");
			}
		}		
	}
}