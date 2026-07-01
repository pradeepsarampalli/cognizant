FUNCTION GetCustomerBalance(
    p_customerid IN NUMBER
)
RETURN NUMBER
IS
    v_balance NUMBER;
BEGIN

    SELECT Balance
    INTO v_balance
    FROM Customers
    WHERE CustomerID = p_customerid;

    RETURN v_balance;

END GetCustomerBalance;