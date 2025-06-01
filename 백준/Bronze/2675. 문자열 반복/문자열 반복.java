import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    // 테스트 케이스의 개수 T
    int T = Integer.parseInt(br.readLine());
    
    // T번 반복 
    for(int i=0; i<T; i++) {
    	// 반복 횟수 R과 문자열 S가 공백으로 구분되어 입력
    	String input[] = br.readLine().split(" ");
    	int R = Integer.parseInt(input[0]);
    	String S = input[1];
    	// R번 반복 + S 길이만큼 반복
    	for(int j=0; j<S.length(); j++) {
    		for(int k=0; k<R; k++) {
    			System.out.print(S.charAt(j)+"");
    		}
    	}
    	System.out.println();    	
    }    
  }
}