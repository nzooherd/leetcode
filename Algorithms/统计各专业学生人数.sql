# Write your MySQL query statement below
SELECT dept_name, count(student_id) as student_number 
FROM department left join student 
ON department.dept_id = student.dept_id GROUP BY department.dept_id ORDER BY student_number desc;