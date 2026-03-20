class Solution {
    public String solution(String s) {
        String[] sArr = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<sArr.length; i++) {
            int tmp = Integer.parseInt(sArr[i]);
            max = Math.max(max, tmp);
            min = Math.min(min, tmp);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(min + " " + max);
        String answer = sb.toString();
        return answer;
    }
}