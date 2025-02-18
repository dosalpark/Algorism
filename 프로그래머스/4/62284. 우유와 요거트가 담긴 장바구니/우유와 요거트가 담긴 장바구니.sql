-- 코드를 입력하세요
SELECT CART_ID
FROM CART_PRODUCTS
WHERE NAME IN ('Milk', 'Yogurt')
GROUP BY CART_ID
HAVING MIN(NAME) = 'Milk' AND MAX(NAME) = 'Yogurt'
ORDER BY CART_ID;