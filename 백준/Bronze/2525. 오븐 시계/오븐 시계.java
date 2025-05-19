import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		String str[] = sc.nextLine().split(" ");
		int Ahour = Integer.parseInt(str[0]);	// 현재 시각의 '시'
		int Bmin = Integer.parseInt(str[1]);	// 현재 시각의 '분'
		int Cmin = sc.nextInt();				// 조리 시간 (분) 
		
		// 출력될 시간의 분 
		int Pmin = 0;
		
		if(Bmin+Cmin>=60)
		{
			// 시간 추가 
			Ahour += (Bmin+Cmin)/60;
			if(Ahour>=24)
			{
				Ahour -= 24;
			}
			
			// 분 추가 
			Pmin = (Bmin+Cmin)%60;			
		}
		else
		{
			Pmin = Bmin+Cmin;
		}
		
		System.out.print(Ahour + " " + Pmin);		
	}
}