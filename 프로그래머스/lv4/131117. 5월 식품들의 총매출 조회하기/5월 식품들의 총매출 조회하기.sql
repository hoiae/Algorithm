 -- 생산일자가  2022-05인 
 -- 식품ID, 식품이름, 총매출을 조회
 -- 총매출을 기준으로 내림차순 정렬, 식품ID기준으로 오름차순 정렬
 
 -- 생산일자가 2022-05인 행을 고름
 -- 상품 id로 그룹화하고 행의 개수를 파악함.
 -- join food_product를 통해서 product_id, product_name, total_sales(count * price)함


-- SELECT
--     B.PRODUCT_ID,
--     B.PRODUCT_NAME,
--     A.COUNT * B.PRICE
--     FROM (
--         SELECT
--             PRODUCT_ID,
--             COUNT(*) COUNT
--             FROM FOOD_ORDER
--             WHERE TO_CHAR(PRODUCE_DATE,'YYYY-MM') = '2022-05'
--             GROUP BY PRODUCT_ID
--     ) A
--     JOIN FOOD_PRODUCT B
--     ON A.PRODUCT_ID = B.PRODUCT_ID;


SELECT
    A.PRODUCT_ID,
    A.PRODUCT_NAME,
    B.COUNT * A.PRICE TOTAL_SALES
    FROM FOOD_PRODUCT A
    JOIN (
        SELECT
            PRODUCT_ID,
            SUM(AMOUNT) COUNT
            FROM FOOD_ORDER
            WHERE TO_CHAR(PRODUCE_DATE,'YYYY-MM') = '2022-05'
            GROUP BY PRODUCT_ID
    ) B
    ON A.PRODUCT_ID = B.PRODUCT_ID
    ORDER BY TOTAL_SALES DESC, PRODUCT_ID ASC;




    