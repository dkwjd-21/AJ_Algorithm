import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 5번째 줄 까지 자연수가 주어짐 
		int[] input = new int[5];
		for(int i=0; i<5; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		
		Arrays.sort(input);
		// 자연수의 합
		int sum = 0;
		for(int i=0; i<5; i++) {
			sum += input[i];
		}
		
		System.out.println((Integer)sum/5);
		System.out.println(input[2]);
		
		br.close();
	}
}
