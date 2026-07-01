create or replace function CalculateMonthlyInstallment (
    l_amount in number,
    intrest_rate in number,
    loan_duration in number
)
return number
as
total number;
begin
total := l_amount + (l_amount * intrest_rate * loan_duration)/100;
return l_amount / (loan_duration * 12);
end;
/