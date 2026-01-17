import java.util.ArrayList;
import java.util.Collections;

class Solution {
	    public ArrayList<Integer> solution(int[] array, int[][] commands) {
	    	// array의 i번째 숫자~j번째 수자 자르고 정렬 -> k번째 있는 수 구하기
	    	// commands : [i, j, k] 2차원 배열 
	        ArrayList<Integer> answer = new ArrayList<Integer>();
	    	
	        for(int i=0; i<commands.length; i++) {
	        	int[] command = commands[i];
	        	
	        	ArrayList<Integer> newArr = new ArrayList<Integer>();
	        	
	        	for(int j=command[0]-1; j<command[1]; j++) {
	        		newArr.add(array[j]);
	        	}
	        	
	        	// 오름차순 정렬 
	        	Collections.sort(newArr); 	  
	        	
	        	// K번째 수 answer에 추가
	        	answer.add(newArr.get(command[2]-1));
	        }
	        
	        return answer;
	    }
	}