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
		
		// 듣도 못한 사람의 수 N, 보도 못한 사람의 수 M 
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		// key:이름 / value:카운트
		HashMap<String, Boolean> list = new HashMap<>();
		
		// 듣도 못한 사람의 이름
		for(int i=0; i<N; i++) {
			list.put(br.readLine(), false);
		}
		
		// 보도 못한 사람의 이름
		for(int i=0; i<M; i++) {
			String str = br.readLine();
		
			// list에 이미 있는 경우 듣보잡이다. 
			if(list.containsKey(str)) {
				list.put(str, true);
			} else {
				list.put(str, false);
			}
		}		
		
		// 듣보잡의 수와 이름을 사전순으로 출력 
		// value값이 true인 사람의 수와 이름을 출력 
		ArrayList<String> unknown = new ArrayList<>();
		Iterator<String> keys = list.keySet().iterator();
		
		while(keys.hasNext()) {
			String key = keys.next();
			
			if(list.get(key)) {
				unknown.add(key);
			}
		}
		
		// 사전순으로 정렬
		unknown.sort((o1, o2) -> o1.compareTo(o2));
		
		bw.append(unknown.size()+"\n");
		for(int i=0; i<unknown.size(); i++) {
			bw.append(unknown.get(i)+"\n");
		}
		
		bw.close();
		br.close();
	}
}