import java.io.*;

public class Main {	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 30명의 번호 명단
		int[] list = new int[30];
		for(int i=0; i<list.length; i++) {
			list[i] = i+1;
		}
		
		// 28줄의 입력 & 입력된 번호의 list 값을 0으로 변경. 
		for(int i=0; i<28; i++) {
			int input = Integer.parseInt(br.readLine());
			list[input-1] = 0;
		}
		
		// 0이 아닌 list 값 출력
		for(int i=0; i<list.length; i++) {
			if(list[i] != 0) {
				System.out.println(list[i]);
			}
		}		
	}
}