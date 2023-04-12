-- 게시글제목, 게시글아이디,댓글아이디,댓글작성자아이디,댓글내용,댓글작성일 조회
-- 댓글 작성일을 기준으로 오르마순 정렬, 같다면 게시글 제목기준 오름차순 정렬
SELECT
    A.TITLE,
    A.BOARD_ID,
    B.REPLY_ID,
    B.WRITER_ID,
    B.CONTENTS,
    TO_CHAR(B.CREATED_DATE,'YYYY-MM-DD') CREATED_DATE
    FROM USED_GOODS_BOARD A
    JOIN USED_GOODS_REPLY B
    ON A.BOARD_ID = B.BOARD_ID
    WHERE TO_CHAR(A.CREATED_DATE, 'YYYY-MM') = '2022-10' 
    ORDER BY B.CREATED_DATE, A.TITLE;