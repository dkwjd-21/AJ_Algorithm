import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        // i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째 있는 수 return
        int[] answer = new int[commands.length];
        
        for(int x=0; x<commands.length; x++) {
            int i = commands[x][0];     
            int j = commands[x][1];
            int k = commands[x][2];
            
            int size = j-i+1;
            int[] newArr = new int[size];
            
            // i ~ j 배열 자르기 
            for(int y=0; y<size; y++) {
                newArr[y] = array[i-1];
                i++;
            }
            
            // 정렬
            Arrays.sort(newArr);
            
            // k번째 수 
            answer[x] = newArr[k-1];
            
        }
        
        
        
        return answer;
    }
}