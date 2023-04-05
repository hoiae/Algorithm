-- CAR_TYPE 이 'SUV'인 자동차들의
-- 평균 일일 대여 요금(원)을 출력한다.
--  소수 첫번째 자리에서 반올림,
--  출력되는 컬럼명은 AVERAGE_FEE
SELECT
    ROUND(AVG(DAILY_FEE)) AVERAGE_FEE
    FROM CAR_RENTAL_COMPANY_CAR
    WHERE CAR_TYPE = 'SUV';