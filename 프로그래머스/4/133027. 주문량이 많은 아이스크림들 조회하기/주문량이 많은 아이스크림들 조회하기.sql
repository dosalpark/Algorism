-- 코드를 입력하세요
SELECT FLAVOR
    FROM (
        SELECT FLAVOR, SUM(TOTAL_ORDER)
        FROM (
            SELECT * FROM FIRST_HALF
            UNION
            SELECT * FROM JULY) a
        GROUP BY 1
        ORDER BY 2 DESC
        LIMIT 3
    ) b;



# SELECT J.FLAVOR, SUM(J.TOTAL_ORDER)
#     FROM FIRST_HALF J
#     GROUP BY J.FLAVOR
#     ORDER BY 2 DESC;

# chocolate	3200
# strawberry	3100
# white_chocolate	3100
    
# strawberry	740
# vanilla	560
# chocolate	520
# peach	500
# caramel	460
# mint_chocolate	400
# white_chocolate	350