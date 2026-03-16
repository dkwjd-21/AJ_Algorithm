class Solution {
    public int solution(String before, String after) {
        // before의 순서를 바꾸어 after를 만들 수 있으면 1, 없으면 0 리턴
        int answer;
        
        /*
            // 첫번째 시도 (평균 5초 정도 소요)
             for(int i=0; i<after.length(); i++) {
            String tmp = after.charAt(i) + "";
            // replaceFirst : 처음 나오는 음절만 대체
            before = before.replaceFirst(tmp, "");
        }
        
        if(before.isEmpty()) {
            answer = 1;
        } else {
            answer = 0;
        }
        
        */
        
        // 성능 개선 버전 - 평균 0.5초 소요
        int[] alphabet = new int[26];
        
        for(int i=0; i<before.length(); i++) {
            alphabet[before.charAt(i) - 'a']++;
            alphabet[after.charAt(i) - 'a']--;
        }
       
        for(int i=0; i<26; i++) {
            if(alphabet[i] != 0) {
                return answer = 0;
            }
        }
        
        return answer = 1;
    }
}
