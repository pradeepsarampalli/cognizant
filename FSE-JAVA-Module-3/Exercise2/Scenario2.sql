create or replace procedure UpdateSalary (
   id in number,
   per in number,
)
is
begin
   update employees set salary = salary + salary*(per/100)
   where id = EmployeeId
   if sql%ROWCOUNT == 0 then
   raise no_data_found;
   end if;
   commit;
exception
 when no_data_found then
   dbms_output.put_line("Noo data found");
when others then
   dbms_output.put_line(sqlerrm)
end;
/

