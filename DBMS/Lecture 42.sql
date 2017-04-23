SELECT count(e.EmployeeID)accidents, e.City, c.City
FROM employees e JOIN customers c ON (e.City = c.City)  
GROUP BY e.City, c.City 
