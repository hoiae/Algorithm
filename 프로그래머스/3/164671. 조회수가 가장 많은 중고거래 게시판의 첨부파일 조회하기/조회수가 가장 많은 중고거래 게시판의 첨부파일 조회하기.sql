-- 조회수가 가장 높은 중고거래 게시글,
-- 첨부파일경로를 조회한다./home/grep/src/ + BOARD_ID + FILE_ID,FILD_NAME,FILE_EXT
-- FILE_ID기준 내림차순 정렬한다.
--     CAT('/home/grep/src/',A.BOARD_ID,A.FILE_ID,FILE_NAME,'.',FILE_EXT) FILE_PATH
 

SELECT
     CONCAT('/home/grep/src/',B.BOARD_ID,"/", A.FILE_ID, A.FILE_NAME, A.FILE_EXT) FILE_PATH
     FROM USED_GOODS_FILE A
     JOIN 
         (SELECT
            BOARD_ID,
            VIEWS
            FROM USED_GOODS_BOARD
            ORDER BY VIEWS DESC
            LIMIT 1) B
        ON A.BOARD_ID = B.BOARD_ID
    ORDER BY A.FILE_ID DESC;

