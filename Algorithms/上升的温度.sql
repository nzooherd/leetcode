# Write your MySQL query statement below
SELECT Id FROM Weather W1
WHERE EXISTS
(SELECT * FROM Weather W2 WHERE TIMESTAMPDIFF(DAY, w2.RecordDate, w1.RecordDate) = 1 AND W2.Temperature < W1.Temperature)
