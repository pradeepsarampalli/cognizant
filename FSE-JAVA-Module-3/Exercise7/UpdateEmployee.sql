PROCEDURE UpdateEmployee(
    p_empid IN NUMBER,
    p_salary IN NUMBER
)
IS
BEGIN

    UPDATE Employees
    SET Salary = p_salary
    WHERE EmployeeID = p_empid;

END UpdateEmployee;