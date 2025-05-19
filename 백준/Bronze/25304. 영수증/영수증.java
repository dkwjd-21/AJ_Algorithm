import java.util.Scanner;

public class Main {	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		// 계산한 총 금액
		int EndPrice = sc.nextInt();
		// 구매한 물건의 종류 수 (반복할 횟수) 
		int kind = sc.nextInt();
		
		sc.nextLine();
		
		// 반복문을 통해 확인해 볼 금액 합계
		int sum = 0;
		
		for(int i=0; i<kind; i++)
		{
			String input[] = sc.nextLine().split(" ");
			int eachPrice = Integer.parseInt(input[0]);
			int count = Integer.parseInt(input[1]);
			
			sum += eachPrice*count;
		}
		
		if(EndPrice == sum)
		{
			System.out.print("Yes");
		}
		else
		{
			System.out.print("No");
		}
	}
}