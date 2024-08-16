-- 코드를 입력하세요
WITH EXAM AS (
    SELECT writer_id, SUM(price) as TOTAL_SALES
    FROM USED_GOODS_BOARD
    WHERE status='DONE'
    GROUP BY writer_id
    HAVING SUM(price) >= 700000
)
SELECT UGU.user_id, UGU.nickname, EX.total_sales
FROM USED_GOODS_USER UGU
JOIN EXAM EX ON EX.writer_id = UGU.user_id
ORDER BY 3 ASC;