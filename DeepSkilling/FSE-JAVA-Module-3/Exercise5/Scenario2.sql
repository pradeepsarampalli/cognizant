create or replace trigger LogTransaction 
after insert on Transactions
for each row
begin
 INSERT INTO AuditLog (
        TransactionID,
        Action,
        ActionDate
    )
    VALUES (
        :NEW.TransactionID,
        'INSERT',
        SYSDATE
    );
end;
/
