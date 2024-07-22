-- 코드를 입력하세요
SELECT 
DATE_FORMAT(OS.SALES_DATE,'%Y') AS YEAR,
DATE_FORMAT(OS.SALES_DATE,'%m') AS MONTH,
UI.GENDER AS GENDER,
COUNT(DISTINCT OS.USER_ID) AS USERS
FROM ONLINE_SALE OS
LEFT JOIN USER_INFO UI ON UI.USER_ID = OS.USER_ID
WHERE UI.GENDER IS NOT NULL
GROUP BY YEAR(SALES_DATE), MONTH(SALES_DATE), UI.GENDER
ORDER BY 1,2,3;