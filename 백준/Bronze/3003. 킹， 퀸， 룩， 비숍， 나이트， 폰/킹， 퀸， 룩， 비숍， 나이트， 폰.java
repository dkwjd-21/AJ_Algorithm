import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 킹1 퀸1 룩2 비숍2 나이트2 폰8
		String[] input = br.readLine().split(" ");
		String[] correct = {"1", "1", "2", "2", "2", "8"};
		
		for(int i=0; i<input.length; i++) {
			if(input[i].equals(correct[i])) {
				System.out.print("0");
			}else {
				System.out.print(Integer.parseInt(correct[i])-Integer.parseInt(input[i]));
			}
			
			if(i!=input.length-1) {
				System.out.print(" ");
			}			
		}		
		
		br.close();
	}
}