FUNCTION CalculateAnnualSalary(
    p_empid IN NUMBER
)
RETURN NUMBER
IS
    v_salary NUMBER;
BEGIN

    SELECT Salary
    INTO v_salary
    FROM Employees
    WHERE EmployeeID = p_empid;

    RETURN v_salary * 12;

END CalculateAnnualSalary;