import java.util.*;

class Solution {
    public int solution(String[] strs, String t) {
        // strs를 조합해 t를 만들기
        // 사용해야 하는 단어조각 개수의 최솟값 return
        // 만들 수 없으면 -1 return
        int answer = 0;
        
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<strs.length; i++) {
            set.add(strs[i]);
        }

        // 단어 조각의 길이는 1~5
        // word[i] = t의 i번째 문자까지 만드는데 쓰는 단어조각 개수의 최솟값
        // ex) t = apple
        //     word[2] = "ap"를 만드는데 쓰는 단어조각 개수의 최솟값
        int[] word = new int[t.length() + 1];
        Arrays.fill(word, Integer.MAX_VALUE);
        word[0] = 0;
        
        for(int i = 1; i <= t.length(); i++) {
            // word[i] 계산 
            for(int j = 1; j <= 5; j++) {
                // 1. 시작 인덱스 계산
                int start = i - j;

                // 2. 시작 인덱스가 0보다 작은지 확인
                if(start < 0) continue;
                
                // 3. 문자열 자르기 
                String tmp = t.substring(start, i);

                // 4. set에 해당 단어가 있는지 확인
                if(set.contains(tmp)) {
                    if(word[i-j] == Integer.MAX_VALUE) continue;
                    
                    // 5. 최소 개수 갱신
                    word[i] = Math.min(word[i], word[i-j]+1);
                }
            }
        }
        
        answer = (word[t.length()]==Integer.MAX_VALUE)? -1 : word[t.length()];
        
        return answer;
    }
}