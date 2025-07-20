import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String isbn[] = br.readLine().split("");
		
		// 각 자리수의 합과 훼손된 숫자의 인덱스
		int sum=0, idx=0;
		
		for(int i=0; i<isbn.length; i++) {
			// 훼손된 숫자가 아닐 경우에만 연산 
			if(!isbn[i].equals("*")) {
				int num = Integer.parseInt(isbn[i]);
				
				// 인덱스를 홀/짝으로 나누어 연산
				sum += ((i+1)%2==0)? 3*num: num;
			} else {
				// 훼손된 숫자의 인덱스
				idx = i; 
			}
		}
		
		// (sum + isbn[i]) % 10 == 0 
		for(int i=0; i<=9; i++) {
			int tmp;
			if((idx+1)%2==0) {
				tmp = sum + 3*i;
				if(tmp%10==0) {
					bw.append(i+"");
					break;
				}
			} else {
				tmp = sum + i;
				if(tmp%10==0) {
					bw.append(i+"");
					break;
				}
			}
		}
		
		
		bw.close();
		br.close();
	}
	
}