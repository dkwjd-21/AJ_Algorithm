import java.io.*;

public class Main {	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 행렬의 크기 N과 M 
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		// 행렬 A의 원소 (N개 줄의 M개 원소)
		int[][] A = new int[N][M];
		for(int i=0; i<N; i++) {
			String[] val = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				A[i][j] = Integer.parseInt(val[j]);
			}
		}
		// 행렬 B의 원소 (N개 줄의 M개 원소)
		int[][] B = new int[N][M];
		for(int i=0; i<N; i++) {
			String[] val = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				B[i][j] = Integer.parseInt(val[j]);
			}
		}
		
		br.close();
		
		// 행렬 A와 B의 더한 행렬
		int[][] sum = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sum[i][j] = A[i][j] + B[i][j];
				System.out.print(sum[i][j]+" ");
			}
			System.out.println();
		}
	}
}