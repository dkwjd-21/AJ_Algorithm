import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 세 점의 좌표 받기 
		String[] inputA = br.readLine().split(" ");
		String[] inputB = br.readLine().split(" ");
		String[] inputC = br.readLine().split(" ");
		
		// 세 점이 가진 X 좌표 세 개. 
		int x[] = {Integer.parseInt(inputA[0]),
				   Integer.parseInt(inputB[0]),
				   Integer.parseInt(inputC[0])};
		// 세 점이 가진 Y 좌표 세 개
		int y[] = {Integer.parseInt(inputA[1]),
				   Integer.parseInt(inputB[1]),
				   Integer.parseInt(inputC[1])};
		
		// 출력할 X값
		int prnX = (x[0]==x[1])? x[2] : (x[0]==x[2])? x[1] : x[0];
		// 출력할 Y값
		int prnY = (y[0]==y[1])? y[2] : (y[0]==y[2])? y[1] : y[0];
		
		System.out.println(prnX + " " + prnY);
		
		br.close();		
	}
}