-- 식품분류별 가격이 제일 비싼 식품의 분류, 가격, 이름 조회 
-- 식품가격을 기준으로 내림차순 정렬 
SELECT CATEGORY, PRICE AS MAX_PRICE, PRODUCT_NAME
FROM FOOD_PRODUCT
WHERE CATEGORY IN ('과자', '국', '김치', '식용유')
  AND PRICE = (
        SELECT MAX(PRICE)
        FROM FOOD_PRODUCT f2
        WHERE f2.CATEGORY = FOOD_PRODUCT.CATEGORY
  )
ORDER BY PRICE DESC;