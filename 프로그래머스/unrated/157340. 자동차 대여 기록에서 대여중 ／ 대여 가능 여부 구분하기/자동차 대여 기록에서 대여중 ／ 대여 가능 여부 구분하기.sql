-- 코드를 입력하세요
-- 컬럼 추가 AVAILABILITY
--  2022-10-16에 대여중인 자동차는 "대여중"으로 표시
--              대여중이지 않은 차는 "대여가능"으로 표시


-- SELECT
--     CAR_ID,
--     COUNT(*)
--     CASE
--         WHEN START_DATE <= TO_DATE('2022-10-16','YYYY-MM-DD') AND END_DATE >= TO_DATE('2022-10-16','YYYY-MM-DD')
--         THEN '대여중'
--         ELSE '대여 가능'
--     END AVAILABILITY
--     FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
--     GROUP BY CAR_ID
--     ORDER BY CAR_ID DESC;


SELECT 
    CAR_ID,
    CASE
        WHEN COUNT = 1 THEN '대여중'
        ELSE '대여 가능'
        END
    FROM(
        SELECT
            CAR_ID,
            COUNT(
                CASE 
                WHEN START_DATE <= TO_DATE('2022-10-16','YYYY-MM-DD') AND END_DATE >= TO_DATE('2022-10-16','YYYY-MM-DD') 
                THEN 1 
                ELSE NULL END
            ) COUNT
            FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
            GROUP BY CAR_ID
            ORDER BY CAR_ID DESC
        )