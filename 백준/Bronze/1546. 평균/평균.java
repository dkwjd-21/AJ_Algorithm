import java.io.*;

public class Main {	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 시험 본 과목의 개수 N
		int N = Integer.parseInt(br.readLine());
		
		int[] score = new int[N];
		String[] input = br.readLine().split(" ");
		
		int M = 0;
		for(int i=0; i<score.length; i++) {
			score[i] = Integer.parseInt(input[i]);
			if(score[i] > M) {
				M = score[i];
			}
		}
		
		// 새로운 점수 배열
		double[] newScore = new double[N];
		double sum = 0;
		for(int i=0; i<score.length; i++) {
			newScore[i] = (double)(score[i]*100)/M;	
			sum += newScore[i];						
		}
		
		System.out.println((double)sum/N);
	}
}