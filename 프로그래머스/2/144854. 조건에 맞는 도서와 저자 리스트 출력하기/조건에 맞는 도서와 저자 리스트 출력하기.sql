-- 코드를 입력하세요
SELECT a.book_id as BOOK_ID, 
b.author_name as AUTHOR_NAME, 
DATE_FORMAT(a.published_date, '%Y-%m-%d') as PUBLISHED_DATE
FROM book a JOIN author b
WHERE a.author_id = b.author_id AND a.category='경제'
ORDER BY a.published_date;