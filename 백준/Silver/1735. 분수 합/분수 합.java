import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 첫번째 분수 
		String[] input = br.readLine().split(" ");
		int firA = Integer.parseInt(input[0]);	// 분자
		int firB = Integer.parseInt(input[1]);	// 분모
		
		// 두번째 분수
		input = br.readLine().split(" ");
		int secA = Integer.parseInt(input[0]);	// 분자
		int secB = Integer.parseInt(input[1]);	// 분모
		
		// 분모들의 최대공약수
		int GCD = GCD(firB, secB);
		
		// 출력할 분수
		int resA=0, resB=0;
		
		if(GCD == 1) {
			// 최대공약수가 1일 때
			resA = firA*secB + secA*firB;
			resB = firB*secB;
		} else {
			// 최대공약수가 1이 아닐 때
			// 분모 : 분모들의 최소공배수
			resB = firB*secB / GCD;
			
			// 분자 : (최소공배수/분모)*원래분자값 들의 합  
			resA = firA*(resB/firB) + secA*(resB/secB);
		}
		
		// 분모, 분자를 최대공약수로 약분 
		GCD = GCD(resA, resB);
		resA = resA/GCD;
		resB = resB/GCD;
		
		bw.append(resA+" "+resB);
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
			b = a%b;		// j로 대입
			a = tmp;		// b로 대입
		}
		return a;			// b가 0, 나머지가 0일 때의 값 리턴
	}
}