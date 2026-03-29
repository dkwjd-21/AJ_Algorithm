import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 문자열의 길이 L
		int L = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		// 해쉬 값
		long hash = 0;
		long pow = 1;
		long M = 1234567891;

		for(int i=0; i<L; i++) {
			char tmp = s.charAt(i);
			
			hash += ((tmp-'a'+1) * pow) % M;
			
			pow = (pow * 31) % M;
		}

		System.out.println(hash);
		br.close();
	}
}