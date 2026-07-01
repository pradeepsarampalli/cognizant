CREATE OR REPLACE PACKAGE EmployeeManagement AS

    PROCEDURE HireEmployee(
        p_empid     IN NUMBER,
        p_name      IN VARCHAR2,
        p_salary    IN NUMBER,
        p_department IN VARCHAR2
    );

    PROCEDURE UpdateEmployee(
        p_empid  IN NUMBER,
        p_salary IN NUMBER
    );

    FUNCTION CalculateAnnualSalary(
        p_empid IN NUMBER
    )
    RETURN NUMBER;

END EmployeeManagement;
/