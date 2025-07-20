import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 이미 심어져 있는 가로수의 수 (3 <= N <= 100,000)
		int N = Integer.parseInt(br.readLine());
		
		// N개의 입력. 심어져 있는 가로수의 위치 (기준점으로부터 가까운 순서)
		List<Integer> tree = new ArrayList<>();
		for(int i=0; i<N; i++) {
			tree.add(Integer.parseInt(br.readLine()));
		}
		
		// 가로수의 간격 리스트
		List<Integer> diff = new ArrayList<>();
		for(int i=0; i<N-1; i++) {
			diff.add(tree.get(i+1)-tree.get(i));
		}
		
		// 간격들의 최대공약수
		int GCD= diff.get(0);
		for(int i=1; i<diff.size(); i++) {
			// 계산한 최대공약수를 그대로 가져가면서 최대공약수를 계산해야한다. 
			GCD = GCD(GCD, diff.get(i)); 
		}
		
		// 간격이 모두 최대공약수 크기만큼 되도록 가로수 추가
		// (각 간격 / 최대공약수 - 1)만큼 추가해야 한다. 
		int cnt = 0;
		for(int i=0; i<diff.size(); i++) {
			int tmp = diff.get(i)/GCD - 1;
			cnt += (tmp>0)? tmp:0;
		}
		
		bw.append(cnt+"");
		
		bw.close();
		br.close();
	}
	
	// 최대공약수를 구하는 함수 (a > b) 
	public static int GCD(int a, int b) {
		int t = a;
		a = Math.max(a, b);
		b = Math.min(t, b);
		
		while(b!=0) {
			int tmp = b;
			b = a%b;		
			a = tmp;		
		}
		return a;	
	}
}
