create procedure ProcessMonthlyInterest 
as 
begin
update Accounts 
set balance = balance + balance * 0.1
where AccountType = 'Savings';
end;
/