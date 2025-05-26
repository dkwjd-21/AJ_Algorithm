import java.io.*;

public class Main {	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 첫째 줄에 N과 M이 주어진다.
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		// N개의 바구니 
		int[] arr = new int[N];
		for(int i=0; i<arr.length; i++) {
			arr[i] = i+1;
		}
		
		// M번 역순 변경
		for(int i=0; i<M; i++) {
			// i와 j입력
			String[] index = br.readLine().split(" ");
			int idxI = Integer.parseInt(index[0]);
			int idxJ = Integer.parseInt(index[1]);
			
			while(idxI < idxJ) {
				int temp = arr[idxI-1];
				arr[idxI-1] = arr[idxJ-1];
				arr[idxJ-1] = temp;
				
				idxI++;
				idxJ--;
			}
		}
		
		// 출력
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}		
	}
}