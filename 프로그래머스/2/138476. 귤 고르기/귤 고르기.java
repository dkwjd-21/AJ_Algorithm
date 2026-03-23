import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        // 한 상자에 담으려는 귤의 개수 k
        // 귤의 크기를 담은 배열 tangerine
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for(int num : tangerine) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        
        // Map의 Entry(Key+Value 쌍)를 리스트로 변환
        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(hashMap.entrySet());

        // Value 기준으로 내림차순 정렬
        entryList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        
        // 서로 다른 종류의 개수
        int answer = 0;
        // 지금까지 담은 귤의 수
        int cnt = 0;
        
        
        for (Map.Entry<Integer, Integer> entry : entryList) {
            int curr = entry.getValue();
            
            if(cnt < k) {
                cnt += curr;
                if(cnt > k) {
                    cnt -= cnt - k;
                }
                answer++;
            }
        }
        
        return answer;
    }
}