import java.util.*;

class Solution {
    public int solution(int N, int number) {
        // N과 사칙연산만 사용해서 number를 표현할 수 있는 방법 중
        // N 사용횟수의 최솟값을 리턴 
        // *8번을 넘어가면 -1을 리턴한다. 
        int answer = 0;
        
        // N과 number가 같으면 바로 1 리턴
        if(N==number) return 1;
        
        List<Set<Integer>> countList = new ArrayList<>();
        for(int i=0; i<9; i++) countList.add(new HashSet<>());
        
        // N을 i번 사용해서 만들 수 있는 숫자를 셋에 채우기 
        for(int i=1; i<9; i++) {
            // N을 i번 이어 붙인 수를 셋에 추가한다
            // ex) N=5, i=2 -> 55 
            Set<Integer> currentSet = countList.get(i);
            currentSet.add(Integer.parseInt(String.valueOf(N).repeat(i)));
            
            // currentSet을 이용하여 사칙연산 조합 
            for(int j=1; j<i; j++) {
                // N을 j번 쓴 셋에서 수를 꺼내오기
                for(int a : countList.get(j)) {
                    // N을 i-j번 쓴 셋에서 수를 꺼내와 연산
                    // ex) i=4, j=1 -> 5와 555를 꺼내와 연산, 
                    //          j=2 -> 55와 55를 꺼내와 연산,
                    //          j=3 -> 555와 5를 꺼내와 연산
                    // * 해당 셋에는 이전 단계에서 연산한 결과도 저장되어 있음
                    //   -> 동적계획법
                    for(int b : countList.get(i-j)) {
                        currentSet.add(a+b);
                        currentSet.add(a-b);
                        currentSet.add(a*b);
                        if(b!=0) currentSet.add(a/b);
                    }
                }
            }
            
            // 현재 셋에 타깃인 number가 있다면 i 리턴하고 종료
            if(currentSet.contains(number)) return i;
        }
        
        // N을 8번 쓰고도 number를 조합하지 못한 경우
        return -1;
    }
}