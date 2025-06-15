import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			
			if(n==-1) {
				break;
			}else {
				// 약수 구하기
				ArrayList<Integer> list = new ArrayList<>();				
				for(int i=1; i<=n-1; i++) {
					if(n%i == 0) {
						list.add(i);
					}
				}
				
				// 약수의 합 구하기
				int sum = 0;
				for(int i=0; i<list.size(); i++) {
					sum += list.get(i);
				}
				
				// 완전수 여부 
				if(sum == n) {
					System.out.print(n+" = ");
					for(int i=0; i<list.size()-1; i++) {
						System.out.print(list.get(i) + " + ");
					}
					System.out.println(list.get(list.size()-1));
				}else {
					System.out.println(n + " is NOT perfect.");
				}				
			}
		}
		
		br.close();
	}
}