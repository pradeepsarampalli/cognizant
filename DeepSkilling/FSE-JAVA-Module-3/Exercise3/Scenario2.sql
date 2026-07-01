create or replace procedure UpdateEmployeeBonus(
bonus in number,
pDepartment in varchar2
)
as
begin
update Employees
set Salary := Salary + (salary * bonus / 100)
where Department = pDepartment;
end;
/