-- 보호소인
# 아이디
# 종
# 보호 시작일
# 보호 시작 시 상태
# 이름
# 성별 및 중성화 여부
-- 보호소 아웃
# 아이디
# 종
# 입양일
# 이름
# 성별 및 중성화 여부
SELECT
    A.ANIMAL_ID,
    A.NAME
    FROM ANIMAL_INS A
    JOIN ANIMAL_OUTS B
    ON A.ANIMAL_ID = B.ANIMAL_ID
    WHERE TIMESTAMPDIFF(SECOND,A.DATETIME, B.DATETIME) < 0
    ORDER BY A.DATETIME