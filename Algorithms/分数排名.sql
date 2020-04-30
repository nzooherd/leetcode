# Write your MySQL query statement below
SELECT Score, (SELECT COUNT(DISTINCT(Score)) FROM Scores S2 WHERE S2.Score > S1.Score) + 1
                 as RANK 
FROM Scores S1
ORDER BY RANK ASC;
