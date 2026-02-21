class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];
        int len = answer.length;
        
        if(direction.equals("left")) {
            for(int i=0; i<len; i++) {
                if(i==len - 1) {
                    answer[i] = numbers[0];
                } else {
                    answer[i] = numbers[i+1];
                }
            }
        } else if(direction.equals("right")) {
            for(int i=0; i<len; i++) {
                if(i==0) {
                    answer[i] = numbers[len-1];
                } else {
                    answer[i] = numbers[i-1];
                }
            }
        }
        
        
        return answer;
    }
}