-- 음식종류별로 즐겨찾기수가 가장 많은 식당의 
-- 음식 종류, ID, 식당 이름, 즐겨찾기 수 조회
-- 음식 종류 기준 내림차순 정렬 
SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
FROM REST_INFO 
WHERE FAVORITES = (
        SELECT MAX(FAVORITES)
        FROM REST_INFO R2
        -- EX) R2.FOOD_TYPE = '한식' -> 한식 중에서 MAX 값인거만 가져옴 
        WHERE R2.FOOD_TYPE = REST_INFO.FOOD_TYPE
    )
GROUP BY FOOD_TYPE
ORDER BY FOOD_TYPE DESC; 