#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int n) {
    // n명이서 한판에 7조각인 피자를 먹을 때, 
    // 모든 사람이 피자를 한 조각 이상 먹기 위해 필요한 피자의 수
    int answer = 0;
    
    answer = n/7;
    if(n%7 != 0) answer++;
    
    return answer;
}