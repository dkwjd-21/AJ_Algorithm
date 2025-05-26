import java.io.*;

public class Main {	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 10개 입력받아서 나머지값 저장
		boolean[] chk = new boolean[42];
		for(int i=0; i<10; i++) {
			// 42로 나눈 나머지에 해당하는 인덱스만 true로 변경 
			chk[Integer.parseInt(br.readLine())%42] = true;
		}
		
		int cnt = 0;
		for(int i=0; i<chk.length; i++) {
			if(chk[i]) {
				cnt++;
			}
		}		
		
		System.out.println(cnt);
	}
}