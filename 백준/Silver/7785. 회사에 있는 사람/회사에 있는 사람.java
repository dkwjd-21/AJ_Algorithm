import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 출입 기록의 수 n
		int n = Integer.parseInt(br.readLine());
		
		// n개의 출입 기록 입력
		HashMap<String, Boolean> enterLog = new HashMap<>();
		String[] input;
		boolean isEnter;
		for(int i=0; i<n; i++) {
			input = br.readLine().split(" ");
			isEnter = (input[1].equals("enter"))? true:false;
			
			if(enterLog.containsKey(input[0])) {
				enterLog.replace(input[0], isEnter);
			} else {
				enterLog.put(input[0], isEnter);
			}			
		}
		
		// value가 enter(=true)인 키값 저장.  
		Iterator<String> keys = enterLog.keySet().iterator();
		ArrayList<String> result = new ArrayList<>();
		while(keys.hasNext()) {
			String key = keys.next();
			if(enterLog.get(key)) {
				result.add(key);
			}
		}
		
		// 역순 정렬
		result.sort((o1, o2) -> o2.compareTo(o1));
		
		// 출력
		for(String str : result) {
			bw.append(str+"\n");
		}
		
		bw.close();
		br.close();
	}
}