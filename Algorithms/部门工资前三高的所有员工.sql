# Write your MySQL query statement below
SELECT Department.Name AS Department, E1.Name AS Employee, Salary FROM Employee E1, Department
 WHERE
E1.DepartmentId = Department.Id 
AND (
    SELECT COUNT(DISTINCT(Salary)) FROM Employee E2 WHERE E2.Salary > E1.Salary AND E2.DepartmentId = E1.DepartmentId
) < 3