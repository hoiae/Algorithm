-- 코드를 입력하세요
-- 년 월 성별로 상품을 구매한 회원수!
-- 성별이 없으면 제외

WITH TEMP AS(
    SELECT 
        EXTRACT(YEAR FROM SALES_DATE) YEAR,
        EXTRACT(MONTH FROM SALES_DATE) MONTH,
        USER_ID
    FROM ONLINE_SALE
)

SELECT 
    A.YEAR,
    A.MONTH, 
    B.GENDER,
    COUNT(DISTINCT A.USER_ID) USERS
  FROM TEMP A
  JOIN USER_INFO B
  ON A.USER_ID = B.USER_ID
  WHERE B.GENDER IS NOT NULL
  GROUP BY A.YEAR, A.MONTH, B.GENDER
  ORDER BY A.YEAR ASC, A.MONTH ASC, B.GENDER ASC;