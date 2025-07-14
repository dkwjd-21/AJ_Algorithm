import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while(true) {
			String input[] = br.readLine().split(" ");
			
			if(input[0].equals("0")) break;
			
			// 변의 길이 배열
			int[] s = new int[3];
			for(int i=0; i<3; i++) {
				s[i] = Integer.parseInt(input[i]); 
			}
			
			// 오름차순 정렬 
			Arrays.sort(s);
			
			// 피타고라스 정리가 성립되면 직각삼각형
			boolean isRight = (s[0]*s[0] + s[1]*s[1] == s[2]*s[2]);
			
			if(isRight) {
				bw.write("right\n");
			} else {
				bw.write("wrong\n");
			}
			
		}
		
		bw.close();
		br.close();
	}
}