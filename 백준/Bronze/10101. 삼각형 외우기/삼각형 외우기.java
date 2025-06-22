import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 3줄에 걸쳐 삼각형의 각 크기가 주어짐
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		int sum = a+b+c;
		
		if(sum!=180) {
			System.out.println("Error");
		} else {
			if (a==b && b==c) {
				System.out.println("Equilateral");
			} else if(a!=b && b!=c && a!=c) {
				System.out.println("Scalene");
			} else {
				System.out.println("Isosceles");
			}
		}	
		
		br.close();
	}
}