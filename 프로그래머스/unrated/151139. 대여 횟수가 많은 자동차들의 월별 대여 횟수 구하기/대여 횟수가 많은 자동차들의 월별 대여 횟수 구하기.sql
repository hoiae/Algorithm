
WITH TEMP AS(
    SELECT
        EXTRACT(MONTH FROM START_DATE) AS MONTH,
        CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE START_DATE BETWEEN TO_DATE('2022-08','YYYY-MM') AND TO_DATE('2022-11', 'YYYY-MM')
),
 ID AS(
    SELECT
        CAR_ID
    FROM TEMP
    GROUP BY CAR_ID
    HAVING COUNT(*) >= 5
 )

SELECT
    MONTH,
    CAR_ID,
    COUNT(*) RECORDS
    FROM TEMP
    WHERE CAR_ID IN (SELECT * FROM ID)
    GROUP BY MONTH, CAR_ID
    ORDER BY MONTH ASC, CAR_ID DESC



    