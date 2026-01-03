import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
	    public int solution(int[][] jobs) {
	    	// 대기 큐 : 작업의 번호, 요청 시각, 소요 시간 저장  
	    	// 요청과 작업 마치는 시점이 겹치면 대기 큐 저장, 작업 시작 순으로 진행
	    	
	    	// jobs : [작업 요청 시점, 작업 소요시간] 
	    	// answer : 모든 요청 작업의 반환 시간의 평균의 정수부분. 
	    	int answer = 0;
	        
	    	// jobs를 요청시간 기준으로 오름차순 정렬
	    	Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
	    	
	        // 우선순위대로 정렬하는 대기 큐 = 힙
	    	PriorityQueue<int[]> jobsHeap = new PriorityQueue<int[]>((a, b) -> {
	    		// int[] = {작업번호, 요청시각, 소요시간}
	    		// 우선순위
	    		// 소요시간이 짧은것 > 요청 시각이 빠른 것 > 번호가 작은 것
	    		
	    		if(a[2] != b[2]) {	// 소요시간 오름차순
	    			return a[2] - b[2];
	    		}
	    		
	    		if(a[1] != b[1]) {	// 요청시각 오름차순 
	    			return a[1] - b[1];
	    		}
	    		
	    		// 소요시간, 요청시각이 모두 같은 경우 번호 오름차순
	    		return a[0] - b[0];
	    	});
	        
	    	// jobs 배열을 순회할 인덱스, 현재 시각
	    	int jobsIdx = 0, currentTime = 0;	
	    	// 작업의 반환 시간을 저장할 리스트 
	    	ArrayList<Integer> jobTimes = new ArrayList<Integer>();
	    	
	    	// 작업이 모두 반환될 때까지 반복 
	    	while(jobTimes.size() < jobs.length) {
	    		// 1. 현재 시각까지 요청된 작업을 힙에 추가
	    		while(jobsIdx < jobs.length && jobs[jobsIdx][0] <= currentTime) {
	    	        jobsHeap.add(new int[]{jobsIdx, jobs[jobsIdx][0], jobs[jobsIdx][1]});
	    	        jobsIdx++;
	    	    }
	    		
	    		// 2. 실행할 작업이 있는지 확인 (=힙에 추가된 작업이 있는지 확인) 
	    		if(!jobsHeap.isEmpty()) {
	    			// 실행할 작업 {작업번호, 요청시각, 소요시간}
	    			int[] targetJob = jobsHeap.poll();
	    			// 작업 실행 = 현재 시각 갱신 
	    			currentTime += targetJob[2];
	    			// 반환 시간 = 작업 종료 시각 - 요청 시각 
	    			jobTimes.add(currentTime - targetJob[1]);   	
	    			
	    		} else {
	    			// 힙이 비어있음 = 요청된 작업이 없음 
	    			// 작업을 힙에 추가할 수 있도록 현재 시각 갱신 
	    			currentTime = jobs[jobsIdx][0];
	    		}
	    	}
	    	
	    	int jobTimeSum = 0;		// 작업의 반환 시간의 합 
	    	for(int time : jobTimes) {
	    		jobTimeSum += time;
	    	}
	    	
	    	// 반환 시간의 평균의 정수부분 반환 
	        return answer = jobTimeSum/jobTimes.size();
	    }
	}