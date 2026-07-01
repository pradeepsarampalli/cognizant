create
or replace function CalculateAge (p_dob in date) return number as begin return floor(months_between (sysdate, p_dob) / 12);

end;

/