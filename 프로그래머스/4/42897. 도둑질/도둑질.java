class Solution {
    public int solution(int[] money) {
        // money : 각 집에 있는 돈이 담긴 배열 
        // 도둑이 훔칠 수 있는 돈의 최댓값 리턴 
        int answer = 0;
        
        // n개의 집 
        int n = money.length;
        
        // case : i번째 집까지 털어서 훔친 돈
        
        // 첫번째 집을 터는 경우 -> 마지막 집을 털 수 없음
        // * 첫번째 집의 돈이 충분히 큰 경우를 가정함 
        int[] case1 = new int[n];
        case1[0] = money[0];
        case1[1] = Math.max(money[0], money[1]);
        for(int i=2; i<n-1; i++) {
            // i번째 집을 터는 경우, 안 터는 경우 중 큰 값으로 추가 
            // -> i번째 집을 터는 경우는 i-2번째 집까지 턴 경우 + money[i] 
            // -> 안 터는 경우는 i-1번째 집까지 턴 경우
            case1[i] += Math.max(case1[i-2]+money[i], case1[i-1]);
        }
        
        // 첫번째 집을 안 터는 경우 -> 마지막 집을 털 수 있음
        int[] case2 = new int[n];
        case2[0] = 0;
        case2[1] = money[1];
        for(int i=2; i<n; i++) {
            case2[i] += Math.max(case2[i-2]+money[i], case2[i-1]);
        }
        
        // 두 시나리오 중 훔친 돈이 더 큰 케이스로 리턴
        // * case1은 마지막집을 털지 않았으니 n-2로 인덱스 지정 
        answer = Math.max(case1[n-2], case2[n-1]);
        return answer;
    }
}