import java.util.*;

class Solution {
    public int solution(String arr[]) {
        // 숫자와 연산자를 분리하여 배열에 저장
        int n = arr.length / 2 + 1; // 숫자의 개수 (ex "1-3+5"면 숫자는 3개)
        int[] nums = new int[n];
        String[] ops = new String[n - 1];

        for (int i = 0; i < arr.length; i++) {
            // 짝수 인덱스는 숫자, 홀수 인덱스는 연산자
            if (i % 2 == 0) nums[i / 2] = Integer.parseInt(arr[i]);
            else ops[i / 2] = arr[i];
        }

        // DP 테이블 초기화 (max와 min 둘 다 필요)
        //                -> max - min 해야 최대값이 나옴 
        // dp[i][j] : i번째 숫자부터 j번째 숫자까지의 연산 결과
        // ex) "1-3+5-8", i=0, j=2 -> "1-3+5"까지 연산 
        int[][] maxDP = new int[n][n];  // maxDP[0][2] = 2 = 1-3+5 
        int[][] minDP = new int[n][n];  // minDP[0][2] = -7 = 1-(3+5)

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 각각 최소값, 최대값으로 초기화
                maxDP[i][j] = Integer.MIN_VALUE; 
                minDP[i][j] = Integer.MAX_VALUE; 
            }
        }

        // 길이 1짜리 초기값 채우기 
        for (int i = 0; i < n; i++) {
            maxDP[i][i] = minDP[i][i] = nums[i];
        }

        // 구간 길이를 늘려가며 계산 (len : 숫자의 개수 범위)
        for (int len = 1; len < n; len++) { 
            for (int i = 0; i < n - len; i++) {
                // i는 시작 숫자 인덱스, j는 끝 숫자 인덱스
                int j = i + len; 
                
                // i와 j 사이의 연산자(k)를 기준으로 반씩 쪼개보기
                for (int k = i; k < j; k++) {
                    if (ops[k].equals("+")) {
                        // 더하기일 때 : (왼쪽 최대 + 오른쪽 최대)가 전체 최대
                        maxDP[i][j] = Math.max(maxDP[i][j], maxDP[i][k] + maxDP[k + 1][j]);
                        minDP[i][j] = Math.min(minDP[i][j], minDP[i][k] + minDP[k + 1][j]);
                    } else {
                        // 뺄셈일 때 : (왼쪽 최대 - 오른쪽 최소)가 전체 최대 
                        maxDP[i][j] = Math.max(maxDP[i][j], maxDP[i][k] - minDP[k + 1][j]);
                        minDP[i][j] = Math.min(minDP[i][j], minDP[i][k] - maxDP[k + 1][j]);
                    }
                }
            }
        }

        return maxDP[0][n - 1]; // 0번부터 마지막 숫자까지의 전체 최댓값 리턴
    }
}