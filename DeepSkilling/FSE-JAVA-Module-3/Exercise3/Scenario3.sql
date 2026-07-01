create
or replace procedure TransferFunds (
    p_from in number,
    P_to in number,
    p_amount in number
) as 
    v_balance number;
begin
select
    balance into v_balance
From
    Accounts
where
    accountid = p_from;

if (v_balance >= p_amount) then
update Accounts
set
    balance = balance - p_amount
where
    accountid = p_from;

update Accounts
set
    balance = balance + p_amount
where
    accountid = P_to;

commit;

DBMS_OUTPUT.PUT_LINE ('Transfer Successful');

else 
DBMS_OUTPUT.PUT_LINE ('insufficent ');

rollback;

end if;

exception when No_DATA_FOUND then rollback; DBMS_OUTPUT.PUT_LINE (sqlerrm);

end;

/