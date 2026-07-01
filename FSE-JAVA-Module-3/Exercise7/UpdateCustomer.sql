PROCEDURE UpdateCustomer(
    p_customerid IN NUMBER,
    p_name IN VARCHAR2
)
IS
BEGIN

    UPDATE Customers
    SET Name = p_name
    WHERE CustomerID = p_customerid;

END UpdateCustomer;