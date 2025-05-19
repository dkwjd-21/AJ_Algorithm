import java.util.Scanner;

public class Main {	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		// n 바이트 입력받음 (4의 배수) 
		int n = sc.nextInt();
		// n을 4로 나눈 몫 = long을 붙일 개수 
		int index = n/4;
		
		String prn = "";
		String basic = "int";
		
		for(int i=0;i<index;i++)
		{
			prn += "long ";
		}
		
		System.out.print(prn+basic);
		
	}
}