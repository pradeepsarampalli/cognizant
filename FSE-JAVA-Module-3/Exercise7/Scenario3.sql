CREATE OR REPLACE PACKAGE AccountOperations AS

    PROCEDURE OpenAccount(
        p_accountid    IN NUMBER,
        p_customerid   IN NUMBER,
        p_accounttype  IN VARCHAR2,
        p_balance      IN NUMBER
    );

    PROCEDURE CloseAccount(
        p_accountid IN NUMBER
    );

    FUNCTION GetTotalBalance(
        p_customerid IN NUMBER
    )
    RETURN NUMBER;

END AccountOperations;
/