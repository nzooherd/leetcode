# Write your MySQL query statement below
SELECT sale_date, sum(case when fruit = 'apples' then sold_num else -sold_num end) as diff
FROM Sales  GROUP BY sale_date;