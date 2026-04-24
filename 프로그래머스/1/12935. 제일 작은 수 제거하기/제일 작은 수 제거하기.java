import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        
        if(arr.length == 1) {
            answer = new int[]{-1};
            return answer;
        }
        
        int min = Integer.MAX_VALUE;
        answer = new int[arr.length-1];
        
        for(int i=0; i<arr.length; i++) {
            min = Math.min(min, arr[i]);
        }
        
        int idx = 0;
        boolean isChk = false;
        for(int num : arr) {
            if(num == min && !isChk) {
                isChk = true;
            } else {
                answer[idx++] = num;
            } 
        }
        
        return answer;
    }
}