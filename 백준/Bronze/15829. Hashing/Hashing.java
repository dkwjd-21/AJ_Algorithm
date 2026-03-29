import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 문자열의 길이 L
		int L = Integer.parseInt(br.readLine());
		// 해쉬 값
		int hash = 0;

		for(int i=0; i<L; i++) {
			char tmp = (char) br.read();
			hash += (int) (((tmp-'a'+1) * Math.pow(31, i)) % 1234567891);
		}

		System.out.println(hash);
		br.close();
	}
}