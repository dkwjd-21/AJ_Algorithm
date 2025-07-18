import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 문자열 S 
		String S = br.readLine();
		
		// 부분 문자열을 저장할 set (중복 허용X) 
		Set<String> partStr = new HashSet<>();
		
		// 부분 문자열 추출하여 set에 저장
		for(int i=0; i<=S.length(); i++) {
			for(int j=i+1; j<=S.length(); j++) {
				String tmp = S.substring(i, j);
				partStr.add(tmp);
			}
		}
		
//		System.out.println(partStr);
		bw.append(partStr.size()+"");
		
		bw.close();
		br.close();
	}
}