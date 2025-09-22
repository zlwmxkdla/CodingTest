-- 각 연도별 최대 크기와 대장균 크기의 차이를 계산합니다.
-- 메인 쿼리에서 YEAR() 함수를 사용해 연도를 추출하고,
-- 서브쿼리를 이용해 각 연도의 최대 크기를 구합니다.
SELECT
    YEAR(DIFFERENTIATION_DATE) AS YEAR,
    (SELECT MAX(SIZE_OF_COLONY) FROM ECOLI_DATA WHERE YEAR=YEAR(DIFFERENTIATION_DATE))-SIZE_OF_COLONY AS YEAR_DEV, ID
    FROM ECOLI_DATA
    ORDER BY YEAR, YEAR_DEV;


