import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 크로아티아 알파벳 배열
		String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		String input = br.readLine();	// 입력		
		
		// 크로아티아 알파벳 배열의 크기만큼 반복문
		for(int i=0; i<croatia.length; i++) {
			// 크로아티아 알파벳을 가지고 있으면
			if(input.contains(croatia[i])) {
				// 크로아티아 알파벳을 #으로 변경 
				input = input.replace(croatia[i], "#");		
			}
		}
		
		System.out.println(input.length());
		br.close();
	}
}