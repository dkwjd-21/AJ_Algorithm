import java.io.*;

public class Main {	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] arr = new int[9][9];
		
		// 2차원 배열 입력받기
		int max = 0;
		int maxI=0, maxJ=0;
		
		for(int i=0; i<arr.length; i++) {
			String[] input = br.readLine().split(" ");
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
				if(arr[i][j] > max) {
					max = arr[i][j];
					maxI = i; 
					maxJ = j;
				}
			}
		}
		
		System.out.println(max);
		System.out.println((maxI+1)+" "+(maxJ+1));
	}
}