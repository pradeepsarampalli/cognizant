PROCEDURE HireEmployee(
    p_empid IN NUMBER,
    p_name IN VARCHAR2,
    p_salary IN NUMBER,
    p_department IN VARCHAR2
)
IS
BEGIN

    INSERT INTO Employees(
        EmployeeID,
        Name,
        Salary,
        Department
    )
    VALUES(
        p_empid,
        p_name,
        p_salary,
        p_department
    );

END HireEmployee;