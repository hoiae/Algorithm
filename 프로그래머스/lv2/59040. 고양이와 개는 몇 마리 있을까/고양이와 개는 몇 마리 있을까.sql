-- 코드를 입력하세요
SELECT
    ANIMAL_TYPE,
    COUNT(*) COUNT
  FROM ANIMAL_INS
  WHERE ANIMAL_TYPE = 'Cat'
  OR ANIMAL_TYPE = 'Dog'
  GROUP BY ANIMAL_TYPE
  ORDER BY ANIMAL_TYPE ASC;