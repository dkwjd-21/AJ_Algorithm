import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String word = br.readLine().toUpperCase();
		int[] cnt = new int[26];
		
		for(char i='A'; i<='Z'; i++) {
			for(int j=0; j<word.length(); j++) {
				if(word.charAt(j) == i) {
					cnt[i-'A']++;
				}
			}
		}		
		
		int max = 0;		// 최댓값
		int idx = 0;		// 최댓값 인덱스
		int maxCount = 0;	// 최댓값 개수
		
		for(int i=0; i<cnt.length; i++) {
			if(cnt[i] != 0 && cnt[i]>=max) {
				if(cnt[i]>max) {
					max = cnt[i];
					idx = i;
					maxCount = 1;
				}else if(cnt[i]==max) {
					maxCount++;					
				}
			}
		}
		
		// 65 -> 'A'
		if(maxCount > 1) {
			System.out.println("?");
		}else {
			System.out.println((char)(idx+65));
		}
		
		br.close();
	}
}