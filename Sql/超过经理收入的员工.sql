# Write your MySQL query statement below
select E1.name as Employee
from Employee  E1 Inner Join Employee  E2
On E1.managerId = E2.Id
where E1.Salary > E2.Salary