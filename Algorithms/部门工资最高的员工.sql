# Write your MySQL query statement below
SELECT Department.Name AS Department, E1.Name AS Employee, Salary FROM Employee E1, Department
 WHERE
E1.DepartmentId = Department.Id 
AND NOT EXISTS
(SELECT * FROM Employee E2 where E2.DepartmentId = E1.DepartmentId AND E2.Salary > E1.Salary)