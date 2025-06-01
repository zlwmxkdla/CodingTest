-- 코드를 입력하세요
SELECT year(b.sales_date) as YEAR,month(b.sales_date) as MONTH, a.gender as GENDER, count(distinct a.user_id) as USERS
from user_info a
    inner join online_sale b
    on a.user_id = b.user_id
group by YEAR,MONTH,GENDER
having gender is not null
order by YEAR,MONTH,GENDER;