import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while(true) {
			String num = br.readLine();
			if(num.equals("0")) break;
			
			String reverse = new StringBuffer(num).reverse().toString();
			if(num.equals(reverse)) {
				bw.append("yes\n");
			} else {
				bw.append("no\n");
			}
		}
		
		bw.close();
		br.close();
	}
}