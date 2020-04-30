# Write your MySQL query statement below
SELECT DISTINCT(Num) AS ConsecutiveNums FROM Logs L1
WHERE EXISTS (
    SELECT * FROM Logs L2 where L2.Id = L1.Id + 1 AND L2.Num = L1.Num
) AND EXISTS(
     SELECT * FROM Logs L3 where L3.Id = L1.Id - 1 AND L3.Num = L1.Num
)