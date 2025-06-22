import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 응시자의 수 N, 상을 받는 사람의 수 k
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		
		// 각 학생의 점수 
		String[] score = br.readLine().split(" ");
		// 각 학생의 점수를 내림차순으로 정렬 
		Arrays.sort(score, (a, b)-> Integer.parseInt(b)-Integer.parseInt(a));
		// k번째 학생의 점수가 커트라인 점수.
		System.out.println(score[k-1]);
		
		br.close();
	}
}