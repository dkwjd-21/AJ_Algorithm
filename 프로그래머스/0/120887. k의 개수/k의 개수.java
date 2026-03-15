class Solution {
    public int solution(int i, int j, int k) {
        // i부터 j까지 k가 몇 번 등장하는지 리턴
        int answer = 0;
        
        for(int num=i; num<=j; num++) {
            String tmp = num+"";
            for(int idx=0; idx<tmp.length(); idx++) {
                if((tmp.charAt(idx)+"").equals(k+"")) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}