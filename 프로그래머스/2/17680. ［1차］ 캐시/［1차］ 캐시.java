import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        Queue<String> queue = new LinkedList<>();
        
        for(int i=0; i<cities.length; i++) {
            if(cacheSize == 0) {
                answer += 5;
                continue;
            }
            
            String city = cities[i].toLowerCase();
            
            if(queue.contains(city)) {
                queue.remove(city);
                queue.add(city);
                answer += 1;
                
            } else {
                if(queue.size() < cacheSize) {
                    queue.add(city);
                    answer += 5;
                } else {
                    queue.poll();
                    queue.add(city);
                    answer += 5;
                }
            }
        }
        
        return answer;
    }
}