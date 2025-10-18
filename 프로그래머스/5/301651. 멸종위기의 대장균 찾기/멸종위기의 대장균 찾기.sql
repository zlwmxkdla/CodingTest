-- 1. WITH RECURSIVE를 사용하여 각 대장균 개체의 세대(GENERATION)를 계산합니다.
WITH RECURSIVE ECOLI_GENERATION AS (
    -- Anchor Member (재귀의 시작: 1세대)
    SELECT
        ID,
        PARENT_ID,
        1 AS GENERATION
    FROM
        ECOLI_DATA
    WHERE
        PARENT_ID IS NULL

    UNION ALL

    -- Recursive Member (재귀 부분: 다음 세대 계산)
    SELECT
        E.ID,
        E.PARENT_ID,
        EG.GENERATION + 1
    FROM
        ECOLI_DATA E
    JOIN
        ECOLI_GENERATION EG ON E.PARENT_ID = EG.ID
)

-- 2. 최종 결과 쿼리: 세대가 계산된 테이블(ECOLI_GENERATION)과 원본 테이블(ECOLI_DATA)을 LEFT JOIN합니다.
SELECT
    COUNT(EG.ID) AS COUNT, -- 자식이 없는 개체의 수를 셉니다.
    EG.GENERATION
FROM
    ECOLI_GENERATION EG
LEFT JOIN
    ECOLI_DATA E_CHILD ON EG.ID = E_CHILD.PARENT_ID
WHERE
    -- 3. 자식이 없는 개체 필터링:
    -- LEFT JOIN 결과에서 자식(E_CHILD)의 ID가 NULL인 경우는
    -- EG.ID를 PARENT_ID로 가지는 자식 개체가 없다는 뜻입니다 (즉, 멸종 위기).
    E_CHILD.ID IS NULL
GROUP BY
    EG.GENERATION
ORDER BY
    GENERATION ASC; -- 세대에 대해 오름차순 정렬