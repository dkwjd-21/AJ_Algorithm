import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// input
		String[] input = br.readLine().split(" ");
		int A = Integer.parseInt(input[0]);
		int B = Integer.parseInt(input[1]);
		int V = Integer.parseInt(input[2]);
		
		// 마지막날 전날, V-A 만큼만 올라가면 됨 
		// 하루에 A-B 만큼 올라감 
		int day = (V-A) / (A-B);
		if((V-A)%(A-B) != 0) {
			// 하루에 올라가는 높이로 V-A를 나누었을때 나누어떨어지지 않음
			// 한번 더 올라가야 함
			day++;
		}
		// V-A 미터 올라온 상황에서 마지막 올라가기 
		day++;
		System.out.println(day);
		br.close();
	}
}