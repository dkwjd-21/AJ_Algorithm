import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 집합 A의 원소의 개수 & 집합 B의 원소의 개수 
		String[] input = br.readLine().split(" ");
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		
		// A와 B 집합 입력
		String[] Aset = br.readLine().split(" ");
		String[] Bset = br.readLine().split(" ");
		
		// 대칭 차집합을 저장할 set 
		Set<String> symdif = new HashSet<>();
		
		// A 집합 입력
		for(int i=0; i<a; i++) {
			symdif.add(Aset[i]);
		}
		
		// B 집합 입력
		// 교집합(이미 저장되어 있는 값)일 경우 삭제 
		for(int i=0; i<b; i++) {
			if(symdif.contains(Bset[i])) {
				symdif.remove(Bset[i]);
			} else {
				symdif.add(Bset[i]);
			}
		}
		
		// 대칭 차집합의 원소의 개수 출력
		bw.append(symdif.size()+"");
		
		bw.close();
		br.close();
	}
}