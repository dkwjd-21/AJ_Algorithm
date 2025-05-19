import java.util.Scanner;

public class Main {	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int sum[] = new int[t];
		// nextInt()는 숫자만 읽고, 엔터는 남기므로 
		// nextLine() 전에 한 줄 소비 필요.
		sc.nextLine();
		
		for(int i=0;i<t;i++)
		{
			// t번 반복 실행
			String str[] = sc.nextLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			
			sum[i] = a+b;
		}
		
		for(int i=0;i<t;i++)
		{
			System.out.println(sum[i]);
		}
	}
}