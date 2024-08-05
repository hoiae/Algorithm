# LENGTH NULL은 길이가 10CM미만
# 물고기 TYPE별로 가장 큰 물고기의 ID, FISH_NAME,LENGTH를 출력해야한다.
# ID에대해 오름차순 정렬한다.

SELECT
    A.ID,
    C.FISH_NAME,
    B.MAX_LENGTH LENGTH
    FROM FISH_INFO A
    JOIN 
        (SELECT 
            FISH_TYPE,
            MAX(LENGTH) MAX_LENGTH
            FROM FISH_INFO
            GROUP BY FISH_TYPE) B
        ON A.FISH_TYPE = B.FISH_TYPE
        AND A.LENGTH = B.MAX_LENGTH
    JOIN FISH_NAME_INFO C
        ON A.FISH_TYPE = C.FISH_TYPE
    ORDER BY A.ID ASC;
    
    
    