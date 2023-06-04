-- category로 그룹화 중 price의 max()사용
-- where 과자 국 김치 식용유
-- rownum >= 1 ??
-- 
-- SELECT
    -- CATEGORY,
    -- B.PRICE,
    -- PRODUCT_NAME
--     FROM(
--         SELECT
        
--         MAX(PRICE)
--         FROM FOOD_PRODUCT
--         GROUP BY CATEGORY
--     )B
--     WHERE PRODUCT_ID = B.PRODUCT_ID 

WITH TEMP AS (
        SELECT
            CATEGORY,
            MAX(PRICE) PRICE
            FROM FOOD_PRODUCT
            WHERE CATEGORY IN ('과자','국','김치','식용유')
            GROUP BY CATEGORY
        )
        
SELECT
    CATEGORY,
    PRICE AS MAX_PRICE,
    PRODUCT_NAME
    FROM FOOD_PRODUCT
    WHERE CATEGORY IN (SELECT CATEGORY FROM TEMP)
    AND PRICE IN (SELECT PRICE FROM TEMP)
    ORDER BY MAX_PRICE DESC;

    
