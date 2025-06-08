import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 단어의 개수 N
		int N = Integer.parseInt(br.readLine());
		
		// 단어의 개수
		int cnt = 0;
		
		// N번 반복
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			// 그룹 단어 체크
			if(groupChk(input)) {
				cnt++;
			}			
		}
		
		System.out.println(cnt);
		br.close();
	}
	
	// 그룹단어 체크 함수
	public static boolean groupChk(String input) {
		boolean isGroup = true;
		
		int[] ch = new int[26];
		// 첫번째 단어에 해당하는 요소는 1로 변경
		ch[input.charAt(0)-'a']=1;
		
		
		// input의 length-1 만큼 반복 (마지막 단어까지 반복X) 
		for(int i=0; i<input.length()-1; i++) {
			// i번째와 i+1번째 단어가 다르다면 그 단어에 해당하는 요소 ++
			if(input.charAt(i)!=input.charAt(i+1)) {
				ch[input.charAt(i+1)-'a']++;
			}
		}
		
		// 기본값보다 큰 경우가 있다면 그룹단어가 아니다.
		for(int i=0; i<ch.length; i++) {
			if(ch[i]>1) {
				isGroup = false;
			}
		}
		
		return isGroup;
	}
}