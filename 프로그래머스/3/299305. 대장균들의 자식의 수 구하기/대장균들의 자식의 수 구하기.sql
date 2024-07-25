-- 코드를 작성해주세요
SELECT E1.ID, COUNT(E2.ID) AS CHILD_COUNT
FROM ECOLI_DATA AS E1
LEFT JOIN ECOLI_DATA AS E2 ON E1.ID = E2.PARENT_ID
GROUP BY ID
ORDER BY ID