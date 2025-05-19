import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		String str[] = sc.nextLine().split(" ");
		int a = Integer.parseInt(str[0]);	// 주사위 1
		int b = Integer.parseInt(str[1]);	// 주사위 2
		int c = Integer.parseInt(str[2]);	// 주사위 3
		
		int money = 0;
		
		if(a==b && a==c)
		{
			// 3개 다 똑같을 때 
			money = 10000+a*1000;
		}
		else if(a!=b && b!=c && a!=c)
		{
			// 3개 다 다를 때
			int max;
			if(a>b && a>c)
			{
				// a가 가장 클 때
				max = a;
			}
			else
			{
				if(b>c)
				{
					// b가 가장 클 때
					max = b;
				}
				else
				{
					// c가 가장 클 때 
					max = c;
				}				
			}
			money = 100*max;
		}
		else
		{
			if(a==b || a==c)
			{
				// a와 b가 같을 경우 or a와 c가 같을 경우
				money = 1000+100*a;
			}
			else
			{
				// b와 c가 같을 경우
				money = 1000+100*b;
			}
		}
		
		System.out.print(money);		
	}
}