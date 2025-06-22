import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		while(true){
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			int c = Integer.parseInt(input[2]);
			
			// 입력값이 0 0 0 일 경우 반복문 종료
			if(a==0 && b==0 && c==0) {
				break;
			}
			
			// 가장 긴 변의 길이
			int max = (a>b && a>c)? a:(b>c && b>a)? b:c; 
			// 나머지 두 변의 길이 합
			int sum = (max==a)? b+c:(max==b)? a+c:a+b;
			
			// 유효한 삼각형이 아닐 경우 
			if(max >= sum) {
				System.out.println("Invalid");
			} else if(a==b && b==c) {
				// 유효한 삼각형 && 정삼각형
				System.out.println("Equilateral ");
			} else if(a!=b && b!=c && a!=c) {
				// 유효한 삼각형 && 세 변의 길이가 모두 다름 
				System.out.println("Scalene");
			} else {
				// 유효한 삼각형 && 이등변 삼각형
				System.out.println("Isosceles");
			}
		}	
		
		br.close();
	}
}