# Write your MySQL query statement below
SELECT Customers.Name as Customers
FROM Customers
WHERE Customers.Id NOT IN
    (SELECT Customers.Id
    FROM Customers INNER JOIN Orders
    ON Customers.Id = Orders.CustomerId)