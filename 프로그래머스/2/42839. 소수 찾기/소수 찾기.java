import java.util.*;

class Solution {
    static HashSet<Integer> numSet = new HashSet<>();
    
    public int solution(String numbers) {
        // numbers : 적힌 숫자의 문자열 (0~9)
        // 만들어진 숫자 set 초기화
        numSet.clear();
        
        // charAt(i)가 숫자 만들기에 사용되었는지 확인하는 배열
        boolean[] used = new boolean[numbers.length()];
        // 숫자 문자열로 새로운 숫자 만들기
        makeNewNum(numbers, "", used);
        
        // 소수의 개수
        int answer = 0;
        
        for(int num : numSet) {
            if(isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    // numbers 배열, 지금까지 만든 수, 숫자 사용 여부 
    public void makeNewNum(String numbers, String current, boolean[] used) {
        // 지금까지 만든 수를 numSet에 추가
        if(!current.isEmpty()) {
            numSet.add(Integer.parseInt(current));
        }
        
        // 새로운 수를 만들기 위해 숫자 고르기 
        for(int i=0; i<used.length; i++) {
            // 이미 사용된 숫자라면 pass
            if(used[i]) continue;
            
            String next = current + numbers.charAt(i);
            used[i] = true;
            makeNewNum(numbers, next, used);
            
            // 사용여부 되돌리기
            used[i] = false; 
        }
    }
    
    
    // n이 소수인지 확인하는 메서드
    public boolean isPrime(int n) {
        // 0과 1은 소수가 아니다. 
        if(n<2) return false;
        
        for(int i=2; i*i<=n; i++) {
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }
}