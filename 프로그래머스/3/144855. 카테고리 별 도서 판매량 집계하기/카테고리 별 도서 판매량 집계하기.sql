-- 코드를 입력하세요
SELECT a.category, sum(sales) as total_sales
from book a 
    inner join book_sales b
    on a.book_id = b.book_id
where date_format(b.SALES_DATE,"%Y-%m-%d") like "2022-01%"
group by a.category
order by a.category;