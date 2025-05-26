import java.io.*;

public class Main {	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[][] arr = new char[5][15];
		
		// 다섯줄의 입력
		for(int i=0; i<5; i++) {
			char[] input = br.readLine().toCharArray();
			for(int j=0; j<input.length; j++) {
				arr[i][j] = (char)input[j];
			}
		}
		
		// 출력
		for(int i=0; i<15; i++) {
			for(int j=0; j<5; j++) {
				// 값이 null 일 때 
				if(arr[j][i] == 0) {
					System.out.print("");
				}else {
					System.out.print(arr[j][i]);
				}				
			}
		}
	}
}