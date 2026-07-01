DECLARE

   CURSOR c_stmt IS
      SELECT t.TransactionID,
             a.CustomerID,
             t.TransactionDate,
             t.Amount,
             t.TransactionType
      FROM Transactions t
      JOIN Accounts a
      ON t.AccountID = a.AccountID
      WHERE EXTRACT(MONTH FROM t.TransactionDate)
              = EXTRACT(MONTH FROM SYSDATE)
      AND EXTRACT(YEAR FROM t.TransactionDate)
              = EXTRACT(YEAR FROM SYSDATE
   v_tid      Transactions.TransactionID%TYPE;
   v_cid      Accounts.CustomerID%TYPE;
   v_date     Transactions.TransactionDate%TYPE;
   v_amount   Transactions.Amount%TYPE;
   v_type     Transactions.TransactionType%TYPE;

BEGIN
   OPEN c_stmt;

   LOOP

      FETCH c_stmt
      INTO v_tid,v_cid,v_date,v_amount,v_type;

      EXIT WHEN c_stmt%NOTFOUND;

      DBMS_OUTPUT.PUT_LINE(
         'Customer: ' || v_cid ||
         ' Amount: ' || v_amount ||
         ' Type: ' || v_type
      );

   END LOOP;

   CLOSE c_stmt;

END;
/