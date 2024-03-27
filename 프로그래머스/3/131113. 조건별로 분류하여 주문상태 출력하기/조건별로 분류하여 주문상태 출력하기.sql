-- 코드를 입력하세요
SELECT ORDER_ID, 
PRODUCT_ID, 
date_format(OUT_DATE,'%Y-%m-%d'),
    CASE
    WHEN OUT_DATE IS NULL
    THEN "출고미정"
    
    WHEN OUT_DATE <= date_format('2022-05-01','%y-%m-%d')
    THEN "출고완료"
    
    WHEN OUT_DATE > date_format('2022-05-01','%y-%m-%d')
    THEN "출고대기"
    
    END AS "출고여부"
FROM FOOD_ORDER
ORDER BY ORDER_ID;