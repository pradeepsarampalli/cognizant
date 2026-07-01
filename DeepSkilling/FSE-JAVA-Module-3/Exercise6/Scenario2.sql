declare 
cursor stmt is
select AccountID from Accounts;
acc_id Accounts.ID%TYPE;
begin
open stmt
loop
fetch stmt
into acc_id;
exit when stmt%NOTFOUND;
update Accounts
set balance = balance - 500 where AccountID = acc_id;
end loop;
close stmt;

commit;
end;
/

