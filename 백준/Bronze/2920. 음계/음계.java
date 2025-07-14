import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 8개의 숫자 입력
		String[] input = br.readLine().split(" ");

		// 첫번째 숫자
		int tmp = Integer.parseInt(input[0]);
		// mixed 인지 체크
		boolean isMixed = false;

		if (tmp == 1) {
			// ascending인지 확인
			for (int i = 1; i < input.length; i++) {
				tmp++;
				if (!input[i].equals(tmp + "")) {
					isMixed = true;
					break;
				}
			}
			
			bw.write((isMixed)? "mixed":"ascending");
			
		} else if (tmp == 8) {
			// descending인지 확인
			for (int i = 1; i < input.length; i++) {
				tmp--;
				if (!input[i].equals(tmp + "")) {
					isMixed = true;
					break;
				}
			}
			
			bw.write((isMixed)? "mixed":"descending");
			
		} else {
			bw.write("mixed");
		}
		
		bw.close();
		br.close();
	}
}