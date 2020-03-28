CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      SELECT Salary FROM Employee E1 
      WHERE (
          (SELECT COUNT(DISTINCT(Salary)) FROM Employee E2 WHERE E2.Salary > E1.Salary) = N - 1) LIMIT 1
      
  );
END