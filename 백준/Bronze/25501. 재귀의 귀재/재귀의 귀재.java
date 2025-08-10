import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 테스트의 개수 T
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			String S = br.readLine();
			
			cnt = 0;
			bw.append(isPalindrome(S)+" "+cnt+"\n");
		}
		
		bw.close();
		br.close();
	}
	
	public static int recursion(String S, int left, int right) {
		cnt++;
		// 문자열의 왼쪽끝, 오른쪽끝부터 커서를 이동시켜서 같은지 확인
		if(left >= right) {
			// 왼쪽 커서가 오른쪽 커서를 넘어가면 확인 끝!
			return 1;
		} else if(S.charAt(left) != S.charAt(right)) {
			// 왼쪽 char != 오른쪽 char 
			// => 팰린드롬이 아님! 
			return 0;
		} else {
			// 왼쪽 char == 오른쪽 char
			// 커서 이동! 
			return recursion(S, left+1, right-1);
		}		
	}
	
	public static int isPalindrome(String S) {
		return recursion(S, 0, S.length()-1);
	}
}