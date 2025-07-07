import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 단어의 개수 N
		int N = Integer.parseInt(br.readLine());
		
		// N개의 단어 입력
		String[] input = new String[N];
		for(int i=0; i<N; i++) {
			input[i] = br.readLine();
		}
		
		// 중복된 단어 제거 (스트림으로 변경하여 distinct() 후 다시 스트링배열로 변환)
		input = Arrays.stream(input).distinct().toArray(String[]::new);
		
		// 문자열의 길이 우선 정렬
		Arrays.sort(input, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) {
					return s1.compareTo(s2);
				} else {
					return s1.length() - s2.length();
				}
			}
		});
		
		
		// 출력
		for(String st : input) {
			System.out.println(st);
		}		
		br.close();
	}
}