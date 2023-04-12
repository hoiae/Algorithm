-- 2022-05에 예약한 환자수, 진료과 코드별로 조회
-- 진료과 코드, 5월 예약 건수
-- 진료과별 예약한 환자수 오름차순 , 진료과 코드 오름차순
SELECT
    MCDP_CD "진료과코드",
    COUNT(*) "5월예약건수"
    FROM APPOINTMENT 
    WHERE TO_CHAR(APNT_YMD,'YYYY-MM') = '2022-05'
    GROUP BY MCDP_CD
    ORDER BY COUNT(*) ASC, MCDP_CD ASC;