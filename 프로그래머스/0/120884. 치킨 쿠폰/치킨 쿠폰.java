class Solution {
    public int solution(int chicken) {
        // chicken 사먹은 치킨의 수 
        // 최대 서비스 치킨의 수 return 
        int answer = -1;
        
        answer = service(chicken, 0);
        
        return answer;
    }
    
    // 주문한 치킨 수, 보유 중인 쿠폰 수
    public int service(int order, int coupon) {
        int newCoupon = order + coupon;  // 새로 생길 쿠폰 수 + 보유 중인 쿠폰 수
        if(newCoupon >= 10) {
            int newOrder = newCoupon / 10;      // 새로운 주문 
            int remainCoupon = newCoupon % 10;  // 남는 쿠폰 수 
            return newOrder + service(newOrder, remainCoupon);
        } else {
            return 0;
        }
    }
}