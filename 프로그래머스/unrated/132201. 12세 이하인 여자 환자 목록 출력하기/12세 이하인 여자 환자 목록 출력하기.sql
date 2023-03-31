--12살이하, 여자,
--이름,번호,성별코드,나이,전화번호 조회할것
-- 전화번호가 없는 경우, NONE으로 출력할것
-- 나이순 내리차순, 동일한 나이일때, 환자이름 순으로 정렬
SELECT
    PT_NAME,
     PT_NO,
    GEND_CD,
    AGE,
    COALESCE(TLNO,'NONE') TLNO
    FROM PATIENT 
    WHERE AGE <= 12
    AND GEND_CD = 'W'
    ORDER BY AGE DESC, PT_NAME ASC; 