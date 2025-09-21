-- 2022년 5월에 예약한 환자 수 & 진료과코드 별 조회 
-- 진료과별 예약한 환자수 기준 오름차순 정렬
-- 진료과 코드 기준 오름차순 정렬 
SELECT MCDP_CD AS '진료과 코드', COUNT(*) AS '5월예약건수'
FROM APPOINTMENT 
WHERE APNT_YMD BETWEEN DATE '2022-05-01' AND DATE '2022-05-31'
GROUP BY MCDP_CD
ORDER BY COUNT(*), MCDP_CD;