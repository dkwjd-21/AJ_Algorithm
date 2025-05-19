import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		String str[] = sc.nextLine().split(" ");
		int hour = Integer.parseInt(str[0]);
		int min = Integer.parseInt(str[1]);
		
		if(min>=45)
		{
			System.out.print(hour + " " + (min-45));
		}
		else
		{
			if(hour>0 && hour<=23)
			{
				System.out.print(hour-1 + " " + (60-(45-min)));
			}
			else 
			{
				System.out.print("23 " + (60-(45-min)));
			}
			
		}
	}
}