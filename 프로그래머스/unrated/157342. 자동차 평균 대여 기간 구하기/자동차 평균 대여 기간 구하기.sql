# 평균 대여기간이 7일 이상인 
# CAR_ID,
#평균대여기간(AVERAGE_DURATION) 소수점 두번째자리 반올림, 
# 애겨기간 기준 내림차순, 자동차ID기준 내림차순

SELECT
    CAR_ID,
    ROUND(AVG(DATEDIFF(END_DATE, START_DATE) + 1), 1) AS AVERAGE_DURATION
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    GROUP BY CAR_ID
    HAVING AVG(DATEDIFF(END_DATE, START_DATE) + 1) >= 7
    ORDER BY AVERAGE_DURATION DESC, CAR_ID DESC