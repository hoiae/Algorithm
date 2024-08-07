#id를 parent_ID로 가지고 있는 컬럼의 수를 구한다.
SELECT
    A.ID,
    COALESCE(B.COUNT,0) AS CHILD_COUNT
 FROM ECOLI_DATA A
 LEFT JOIN 
     (SELECT
        PARENT_ID AS ID,
        COUNT(*) AS COUNT
      FROM ECOLI_DATA
      WHERE PARENT_ID IS NOT NULL  
      GROUP BY PARENT_ID) B
ON A.ID = B.ID
ORDER BY ID ASC;

