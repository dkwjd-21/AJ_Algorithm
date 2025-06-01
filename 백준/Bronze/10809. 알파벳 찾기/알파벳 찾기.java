import java.io.*;
import java.util.StringTokenizer;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    // 소문자로만 이루어진 단어 S
    String s = br.readLine();
    int res[] = new int[26];
    // -1로 초기화
    for(int i=0; i<res.length; i++) {
    	res[i] = -1;
    }
    
    // 각각의 알파벳에 대해서 처음 등장하는 위치 공백 구분으로 출력
    // 포함되어 있지 않다면 -1 
    for(char i='a'; i<='z'; i++) {
    	for(int j=0; j<s.length(); j++) {
    		if(s.charAt(j)==i) {
    			// 위치 = j
    			// 'a'-'a' = 0 -> int 변환으로 사용 
    			res[i-'a'] = j;
    			break;		// 처음 조건을 만족할 때만 적용
    		}
    	}
    }
    
    for(int i=0; i<res.length; i++) {
    	System.out.print(res[i]+" ");
    }
    
  }
}