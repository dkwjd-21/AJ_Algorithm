import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        // n : 사람의 수
        // words : 사람들이 순서대로 말한 단어
        int[] answer = {0, 0};

        // 중복 여부 확인을 위한 단어 셋 & 큐 
        HashSet<String> wordSet = new HashSet<String>();   
        int idx = 1;         // 사람들의 번호 (1~n)
        int turn = 1;        // 현재 라운드
       char lastChr = words[0].charAt(0);   // 끝말잇기 규칙을 지켰는지 확인 
        
        for(int i=0; i<words.length; i++) {
            String word = words[i];
            
            // [탈락] 끝말잇기가 안됨 (첫 단어 제외)
            if(i>0 && word.charAt(0) != lastChr) {
                answer[0] = idx;
                answer[1] = turn;
                return answer;
            }
            
            // [탈락] 이전에 등장했던 단어 or 한 글자 단어임
            if(wordSet.contains(word) || word.length() <= 1) {
                answer[0] = idx;
                answer[1] = turn;
                return answer;
            }
            
            // 끝말잇기 성공
            wordSet.add(word);
            lastChr = word.charAt(word.length()-1);
            
            if(idx == n) {
                idx = 1;
                turn++;
            } else {
                idx++;
            }
        }
        
        return answer;
    }
}