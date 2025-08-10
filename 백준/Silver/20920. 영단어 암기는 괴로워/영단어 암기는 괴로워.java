import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 영어 지문에 나오는 단어의 개수 N 
		// 외울 단어의 길이 기준이 되는 M 
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		// 외울 단어 키-단어, 값-나온횟수
		Map<String, Integer> words = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			String word = br.readLine();
			
			// 단어의 길이가 M 이상인 단어만 외운다.
			if(word.length() >= M) {
				if(words.containsKey(word)) {
					// 이미 단어장에 있는 단어면 나온 횟수를 더한다. 
					words.replace(word, words.get(word)+1);
				} else {
					// 단어장에 없는 단어면 추가한다.
					words.put(word, 1);
				}				
			}
		}
		
		// 정렬 순서  
		// 1. 자주 나오는 단어일수록 앞에 배치한다.
		// 2. 해당 단어의 길이가 길수록 앞에 배치한다.
		// 3. 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다
		ArrayList<String[]> wordbook = new ArrayList<>();
		Set<String> keys = words.keySet();
		for(String key : keys) {
			String[] add = {key, words.get(key)+""};
			wordbook.add(add);
		}
		
		Collections.sort(wordbook, new Comparator<String[]>() {
			@Override
			public int compare(String[] s1, String[] s2) {
				// s1 단어와 나온 횟수
				String word1 = s1[0];
				int cnt1 = Integer.parseInt(s1[1]);
				// s2 단어와 나온 횟수
				String word2 = s2[0];
				int cnt2 = Integer.parseInt(s2[1]);
				
				// 나온 횟수가 같을 때 
				if(cnt1 == cnt2) {
					// 단어의 길이가 같을 때 
					if(word1.length() == word2.length()) {
						// 3. 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다
						return word1.compareTo(word2);
					} else {
						// 2. 단어의 길이가 긴 순서로 정렬 
						return word2.length()-word1.length();
					}
				}  else {
					// 1. 나온 횟수 내림차순
					return cnt2-cnt1;
				}
			}		
		});
		
		for(int i=0; i<wordbook.size(); i++) {
			bw.append(wordbook.get(i)[0]+"\n");
		}
		
		bw.close();
		br.close();
	}
}