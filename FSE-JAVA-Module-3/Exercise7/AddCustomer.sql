PROCEDURE AddCustomer(
    p_customerid IN NUMBER,
    p_name       IN VARCHAR2,
    p_dob        IN DATE,
    p_balance    IN NUMBER,
    p_isvip      IN VARCHAR2
)
IS
BEGIN

    INSERT INTO Customers
    VALUES (
        p_customerid,
        p_name,
        p_dob,
        p_balance,
        SYSDATE,
        p_isvip
    );

END AddCustomer;