import java.util.*;

class Solution {
    public String solution(String letter) {
        
        Map<String, String> morse = new HashMap<>();
        String[] morseArray = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        for (int i = 0; i < morseArray.length; i++) {
            morse.put(morseArray[i], Character.toString((char)('a' + i)));
        }
        
        String[] words = letter.split(" ");
        StringBuilder answer = new StringBuilder();
        
        for(String word : words) {
            answer.append(morse.get(word));
        }
        
        return answer.toString();
    }
}