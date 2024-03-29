-- PUBLISHED_DATE = 2021년인
-- CATEGORY = '인문'
-- BOOK_ID,PUBLISHED_DATE
-- PUBLISHED_DATE 오름차순
SELECT
    BOOK_ID,
    TO_CHAR(PUBLISHED_DATE, 'YYYY-MM-DD')
  FROM BOOK
  WHERE TO_CHAR(PUBLISHED_DATE,'YYYY') = '2021'
  AND CATEGORY = '인문'
  ORDER BY PUBLISHED_DATE ASC;