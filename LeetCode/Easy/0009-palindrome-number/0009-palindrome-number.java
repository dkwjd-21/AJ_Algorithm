class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        
        // 자릿수 
        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }

        while(x!=0) {
            // 맨 앞자리 수
            int fir = x / div;
            // 맨 뒷자리 수
            int last = x % 10;

            // 양 끝이 다르면 팰린드롬이 아님
            if(fir != last) return false;

            x = (x % div) / 10;
            div /= 100;        
        }

        return true;
    }
}