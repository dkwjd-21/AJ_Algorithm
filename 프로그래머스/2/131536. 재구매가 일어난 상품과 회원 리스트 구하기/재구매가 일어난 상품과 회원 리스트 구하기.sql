-- 동일한 회원이 동일한 상품을 재구매한 데이터 
-- 재구매한 회원 ID, 재구매한 상품 ID 출력
-- 회원 ID 오름차순, 상품 ID 내림차순 정렬 
SELECT USER_ID, PRODUCT_ID
FROM ONLINE_SALE
GROUP BY PRODUCT_ID, USER_ID
HAVING COUNT(*) >= 2
ORDER BY USER_ID, PRODUCT_ID DESC;