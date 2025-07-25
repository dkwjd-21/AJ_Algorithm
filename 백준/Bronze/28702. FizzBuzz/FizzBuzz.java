import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = new String[3];
		// 세 개의 문자열 입력
		for(int i=0; i<3; i++) {
			input[i] = br.readLine();
		}
		
		int res = FBtoInt(input);
		
		bw.append(FizzBuzz(res));

		bw.close();
		br.close();
	}
	
	// 네번째 올 수를 구하는 함수
	public static int FBtoInt(String[] input) {
		int res = 0;
		for(int i=0; i<input.length; i++) {
		    if(input[i].equals("FizzBuzz")) {
		    	
		    	
			} else if(input[i].equals("Fizz")) {
				
				
			} else if(input[i].equals("Buzz")) {
				
				
			} else {
				res = Integer.parseInt(input[i])+(3-i);
				break;
			}
		}
		return res;
	}
	
	// FizzBuzz 판단 함수
	public static String FizzBuzz(int x) {
		if(x%3==0 && x%5==0) {
			return "FizzBuzz";
		} else if(x%3==0) {
			return "Fizz";
		} else if(x%5==0) {
			return "Buzz";
		} else {
			return x+"";
		}
	}
}