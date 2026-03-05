class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        for(int i=0; i<array.length; i++) {
            String str = array[i]+"";
            
            for(int j=0; j<str.length(); j++) {
                int tmp = Integer.parseInt(str.charAt(j)+"");
                if(tmp == 7) answer++;
            }
            
        }
        
        return answer;
    }
}