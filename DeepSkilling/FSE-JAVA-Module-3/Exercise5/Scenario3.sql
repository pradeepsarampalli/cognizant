create or replace trigger CheckTransactionRules
before insert
on Transactions
for each row
declare 
v_balance number;
begin
IF :NEW.TransactionType = 'Deposit' THEN

        IF :NEW.Amount <= 0 THEN
            RAISE_APPLICATION_ERROR(
                -20001,
                'Deposit amount must be positive.'
            );
        END IF;

    ELSIF :NEW.TransactionType = 'Withdrawal' THEN

        SELECT Balance
        INTO v_balance
        FROM Accounts
        WHERE AccountID = :NEW.AccountID;

        IF :NEW.Amount > v_balance THEN
            RAISE_APPLICATION_ERROR(
                -20002,
                'Insufficient balance.'
            );
        END IF;

    END IF;
END;
/
