class Solution
{
    public int solution(int n, int a, int b)
    {
        // n명의 참가자 토너먼트
        // 처음 라운드 a번과 b번은 몇 번째 라운드에서 만나는지 return 
        // n명은 짝수로 주어짐 -> 부전승 발생X
        
        // 1라운드부터 시작
        int answer = 1;

        // 두 번호가 인접하고 홀수-짝수 순서면 해당 라운드에서 만남 (짝수-홀수 순서면 만나지 않음)
        int abs = Math.abs(a-b);    // abs가 1이어야 인접함
        int max = Math.max(a, b);   // max가 짝수여야함 
        
        while(abs != 1 || max%2 != 0) {
            // 다음 라운드 번호 계산
            // a 번호가 짝수 -> a/2가 다음 번호
            // a 번호가 홀수 -> (a+1)/2가 다음 번호
            if(a%2 == 0) {
                a /= 2;
            } else {
                a = (a+1)/2;
            }
            
            if(b%2 == 0) {
                b /= 2;
            } else {
                b = (b+1)/2;
            }
            
            // 다음 라운드의 abs, max 계산
            abs = Math.abs(a-b);
            max = Math.max(a, b);
            
            // 다음 라운드 진행
            answer++;
        }

        return answer;
    }
}