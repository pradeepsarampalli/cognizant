CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    PROCEDURE OpenAccount(
        p_accountid    IN NUMBER,
        p_customerid   IN NUMBER,
        p_accounttype  IN VARCHAR2,
        p_balance      IN NUMBER
    )
    IS
    BEGIN
        INSERT INTO Accounts(
            AccountID,
            CustomerID,
            AccountType,
            Balance
        )
        VALUES(
            p_accountid,
            p_customerid,
            p_accounttype,
            p_balance
        );
    END OpenAccount;


    PROCEDURE CloseAccount(
        p_accountid IN NUMBER
    )
    IS
    BEGIN
        DELETE FROM Accounts
        WHERE AccountID = p_accountid;
    END CloseAccount;


    FUNCTION GetTotalBalance(
        p_customerid IN NUMBER
    )
    RETURN NUMBER
    IS
        v_total NUMBER;
    BEGIN
        SELECT SUM(Balance)
        INTO v_total
        FROM Accounts
        WHERE CustomerID = p_customerid;

        RETURN NVL(v_total,0);
    END GetTotalBalance;

END AccountOperations;
/