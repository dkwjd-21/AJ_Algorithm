import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// B진법 수 N이 주어진다.
		String[] input = br.readLine().split(" ");
		String N = input[0];
		int B = Integer.parseInt(input[1]);
		
		// 10진법으로 출력한다.
		System.out.println(Integer.parseInt(N, B));
		
		br.close();
	}
}