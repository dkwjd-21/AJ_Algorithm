import java.util.ArrayList;

class Solution {
		public ArrayList<Integer> solution(int[] answers) {
			// 1번 수포자 : 1, 2, 3, 4, 5, ... (5개 반복) 
			// 2번 수포자 : 2, 1, 2, 3, 2, 4, 2, 5, ... (8개 반복)
			// 3번 수포자 : 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ... (10개 반복) 
			// answers : 문제의 정답이 순서대로 들은 배열 
			
			// 가장 많은 문제를 맞힌 사람 
			ArrayList<Integer> answer = new ArrayList<Integer>();
			
			// 1~3번 수포자의 찍는 방식 패턴 
			int[] pattern1 = {1, 2, 3, 4, 5};
			int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
			int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
			
			// 3명의 점수 배열 
			int[] scores = new int[3];
			
			for(int i=0; i<answers.length; i++) {
				// 1번 수포자 
				if(answers[i] == pattern1[i%pattern1.length]) {
					scores[0]++;
				}
				// 2번 수포자 
				if(answers[i] == pattern2[i%pattern2.length]) {
					scores[1]++;
				}
				// 3번 수포자 
				if(answers[i] == pattern3[i%pattern3.length]) {
					scores[2]++;
				}				
			}
			
			// 최고점 
			int max = Math.max(scores[0], Math.max(scores[1], scores[2]));
			
			for(int i=0; i<scores.length; i++) {
				// 최고점에 해당하는 사람의 번호(인덱스+1)를 answer 리스트에 추가 
				if(max == scores[i]) {
					answer.add(i+1);
				}
			}
		
			return answer;
		}
	}