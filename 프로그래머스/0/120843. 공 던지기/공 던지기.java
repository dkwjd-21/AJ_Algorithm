class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        
        // 첫 번째로 공을 가지고 있는 사람
        int tmp = numbers[0];
        
        for(int i=1; i<k; i++) {
            if(tmp == numbers.length - 1) {
                // 만약 공을 가지고 있는 사람이 제일 끝에서 앞 번호라면
                // 첫번째 사람에게 공을 던짐
                tmp = numbers[0];
            } else if(tmp == numbers.length) {
                // 만약 공을 가지고 있는 사람이 제일 끝 번호라면
                // 두번째 사람에게 공을 던짐
                tmp = numbers[1];
            } else {
                // 인덱스에 제약이 없다면 번호 하나 건너뛰고 공 던짐
                tmp = numbers[tmp+1];
            }
            
        }
        
        return answer = tmp;
    }
}