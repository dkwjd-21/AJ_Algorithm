class Solution {
    public long solution(long n) {
        long answer = 0;
        
        int[] numCnt = new int[10];
        while(n!=0) {
            numCnt[(int) (n%10)]++;
            n = n/10;
        }
        
        StringBuilder st = new StringBuilder();
        for(int i=9; i>=0; i--) {
            for(int j=0; j<numCnt[i]; j++) {
                st.append(String.valueOf(i));  
            }
        }
        
        answer = Long.parseLong(st.toString());
        
        return answer;
    }
}