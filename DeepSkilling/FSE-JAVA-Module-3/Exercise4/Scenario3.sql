create
or replace function HasSufficientBalance (t_accountid in number, amount in number) return varchar as tbalance number;

begin
select
    balance into tbalance
from
    Accounts
where
    accountid = t_accountid;

if (tbalance >= amount) then return 'true';

else return 'false';

end if;

end;

/