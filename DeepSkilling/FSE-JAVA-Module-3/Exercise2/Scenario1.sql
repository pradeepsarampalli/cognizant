create or replace procedure SafeTransfer(
   formacc in number,
   toacc in number,
   amount in number
)
v_balance Accounts.Balanace%TYPE;
insufficient_funds EXCEPTION;
begin
 SELECT Balance
    INTO v_balance
    FROM Accounts
    WHERE AccountID = p_from_account;

if v_balance < amount then
raise insufficient_funds;
end if;

UPDATE Accounts
    SET Balance = Balance - p_amount
    WHERE AccountID = p_from_account;

    UPDATE Accounts
    SET Balance = Balance + p_amount
    WHERE AccountID = p_to_account;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Transfer Successful');
EXCEPTION
   when insufficient_funds then
      DBMS_OUTPUT.PUT_LINE("insufficient_funds");
      rollback;
   when others then
   DBMS_OUTPUT.PUT_LINE(sqlerrm)
   rollback;