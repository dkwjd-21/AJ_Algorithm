import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		double cnt = 0.0;		// 학점의 총합
		double sum = 0.0;		// 학점*과목평점의 합 
		
		// 등급에 따른 과목평점 
		HashMap<String, Double> Score = new HashMap<String, Double>();
		Score.put("A+", 4.5);
		Score.put("A0", 4.0);
		Score.put("B+", 3.5);
		Score.put("B0", 3.0);
		Score.put("C+", 2.5);
		Score.put("C0", 2.0);
		Score.put("D+", 1.5);
		Score.put("D0", 1.0);
		Score.put("F", 0.0);
		
		// 20줄에 걸쳐 과목명, 학점, 등급이 공백 구분으로 주어짐
		for(int i=0; i<20; i++) {
			String[] input = br.readLine().split(" ");
			double credit = Double.parseDouble(input[1]);	// 학점
			String grade = input[2];						// 등급
			
			// 등급이 P면 체크하지 않음
			if(grade.equals("P")) {
				continue;
			}else {
				cnt += credit;
				sum += credit*Score.get(grade);
			}			
		}		
		
		
		System.out.println(sum/cnt);
		br.close();
	}
}