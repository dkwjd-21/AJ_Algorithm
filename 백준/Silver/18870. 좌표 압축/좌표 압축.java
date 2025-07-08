import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 좌표의 개수 N
		int N = Integer.parseInt(br.readLine());
		
		// 좌표 입력 
		int[] list = new int[N];
		String[] input = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			list[i] = Integer.parseInt(input[i]);
		}
		
		// 원본 배열에서 중복 요소 제거 + 오름차순 정렬한 압축배열
		int compression[] = Arrays.stream(list).distinct().sorted().toArray();
		HashMap<Integer, Integer> comMap = new HashMap<>();
		for(int i=0; i<compression.length; i++) {
			comMap.put(compression[i], i);
		}
		
		// 압축배열의 인덱스 출력
		for(int i=0; i<N; i++) {
			bw.append(comMap.get(list[i])+" ");  
		}
		
		bw.close();
		br.close();
	}
}