import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N장과 숫자 M 
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		// N장의 숫자 카드 
		int[] card = new int[N];
		input = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			card[i] = Integer.parseInt(input[i]);
		}
		
		// card 오름차순 정렬
		Arrays.sort(card);
		
		int sum = 0;
		
		// i : 첫번째 수 
		for(int i=0; i<=card.length-3; i++) {
			// j : 두번째 수
			for(int j=i+1; j<=card.length-2; j++) {
				// k : 세번째 수
				for(int k=j+1; k<=card.length-1; k++) {
					int tmp = card[i]+card[j]+card[k];
					
					if(tmp > M) {
						break;
					} else {
						sum = (tmp>=sum)? tmp:sum;
					}
				}
			}			
		}
		
		System.out.println(sum);		
		br.close();
	}
}