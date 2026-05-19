class Solution {
    public int romanToInt(String s) {
        // 로마 숫자 -> 아라비아 숫자
        int answer = 0;
        int n = s.length();
        int idx = 0;

        while(idx < n) {
            char curr = s.charAt(idx);
            idx++;

            char next = ' ';
            if(idx != n) {
                next = s.charAt(idx);
            }

            switch(curr) {
                case('I'):
                    if(next == 'V' || next == 'X'){
                        answer -= 1;
                    } else {
                        answer += 1;
                    }
                    break;
                case('V'):
                    answer += 5;
                    break;
                case('X'):
                    if(next == 'L' || next == 'C'){
                        answer -= 10;
                    } else {
                        answer += 10;
                    }
                    break;
                case('L'):
                    answer += 50;
                    break;
                case('C'):
                    if(next == 'D' || next == 'M'){
                        answer -= 100;
                    } else {
                        answer += 100;
                    }
                    break;
                case('D'):
                    answer += 500;
                    break;
                case('M'):
                    answer += 1000;
                    break;
            }
        }

        return answer;
    }
}